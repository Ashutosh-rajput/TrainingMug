package TrainingMug.Car.Management.Mapper;


import TrainingMug.Car.Management.DTO.CarRegistrationDTO;
import TrainingMug.Car.Management.DTO.CarResponseDTO;
import TrainingMug.Car.Management.Entity.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CarMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CarResponseDTO CartoCarResponseDTo(Car car){
        return modelMapper.map(car, CarResponseDTO.class);
    }

    public CarRegistrationDTO CartoCarRegistrationDTo(Car car){
        return modelMapper.map(car, CarRegistrationDTO.class);
    }

    public Car CarRegistrationDTotoCar(CarRegistrationDTO carRegistrationDTO){
        return modelMapper.map(carRegistrationDTO, Car.class);
    }



}
