package TrainingMug.Car.Management.Service.ServiceImpl;


import TrainingMug.Car.Management.DTO.CarRegistrationDTO;
import TrainingMug.Car.Management.DTO.CarResponseDTO;
import TrainingMug.Car.Management.Entity.Car;
import TrainingMug.Car.Management.ExceptionHandling.ResourceAlreadyExistsException;
import TrainingMug.Car.Management.ExceptionHandling.ResourceNotFoundException;
import TrainingMug.Car.Management.Mapper.CarMapper;
import TrainingMug.Car.Management.Repository.CarRepo;
import TrainingMug.Car.Management.Service.ServiceInterface.CarServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CarServiceImpl implements CarServiceInterface {


    @Autowired
    private CarRepo carRepo;

    @Autowired
    private CarMapper carMapper;

    @Override
    public CarResponseDTO createCar(CarRegistrationDTO carRegistrationDTO) {
        if (carRepo.findByName(carRegistrationDTO.getName()).isPresent()) {
            log.error("Car registration failed: Car details already exists with name: {}", carRegistrationDTO.getName());
            throw new ResourceAlreadyExistsException("Car registration failed: Car details already exists with name: "+ carRegistrationDTO.getName());
        }
        Car car=carMapper.CarRegistrationDTotoCar(carRegistrationDTO);
        Car savedCar=carRepo.save(car);;
        log.info("Car registration successfully with ID: {}", savedCar.getId());
        return carMapper.CartoCarResponseDTo(savedCar);
    }

    @Override
    public CarResponseDTO getCarById(Long id) {
        Car car = carRepo.findById(id).orElseThrow(() -> {
            log.error("Car details not found with ID: {}", id);
            return new ResourceNotFoundException("Car details not found with this ID."+ id);
        });
        log.info("Car details found with ID: {}", id);
        return carMapper.CartoCarResponseDTo(car);
    }

    @Override
    public CarResponseDTO updateCar(CarRegistrationDTO carRegistrationDTO, Long id) {
        Car car = carRepo.findById(id).orElseThrow(() -> {
            log.error("Car details not found with ID: {}", id);
            return new ResourceNotFoundException("Car details not found with this ID."+ id);
        });
        log.info("Car details found with ID: {}", id);

        // Update fields if they are not null in the DTO
        Optional.ofNullable(carRegistrationDTO.getName()).ifPresent(car::setName);
        Optional.ofNullable(carRegistrationDTO.getModel()).ifPresent(car::setModel);
        Optional.ofNullable(carRegistrationDTO.getColor()).ifPresent(car::setColor);
        Optional.ofNullable(carRegistrationDTO.getFueltype()).ifPresent(car::setFueltype);
        if(carRegistrationDTO.getYear() != 0){
            car.setYear(carRegistrationDTO.getYear());
        }
        if(carRegistrationDTO.getPrice() != 0){
            car.setPrice(carRegistrationDTO.getPrice());
        }
        Car updatedCar=carRepo.save(car);
        log.info("Car details updated Successfully.");

        return carMapper.CartoCarResponseDTo(updatedCar);
    }

    @Override
    public String deleteCar(Long id) {
        Car car = carRepo.findById(id).orElseThrow(() -> {
            log.error("Car details not found with ID: {}", id);
            return new ResourceNotFoundException("Car details not found with this ID."+ id);
        });
        log.info("Car details found with ID: {}", id);
        carRepo.delete(car);
        log.info("Car details deleted successfully found with ID: {}", id);

        return "Car details deleted successfully found with ID: "+ id;
    }

    @Override
    public Page<CarResponseDTO> ListOfCars(int page, int size, String field,String order) {
        Sort.Direction sortDirection = order.equalsIgnoreCase("Descending") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, field));

        Page<Car> cars = carRepo.findAll(pageable);
        if (cars.isEmpty()) {
            log.warn("No Cars found for the given criteria.");
        } else {
            log.info("Number of cars found: {}", cars.getTotalElements());
        }
        return cars.map(car -> carMapper.CartoCarResponseDTo(car));

    }

    @Override
    public List<CarResponseDTO> searchCarByKeyword(String keyword) {
        List<Car> cars=carRepo.searchKeyword(keyword);
        if(cars.size()==0){
            throw new ResourceNotFoundException("No cars found with this keyword: "+ keyword);
        }
        log.info("No. of cars found: " + cars.size());

        return cars.stream().map(carMapper::CartoCarResponseDTo).toList();
    }
}
