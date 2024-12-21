package TrainingMug.Car.Management.Service.ServiceInterface;


import TrainingMug.Car.Management.DTO.CarRegistrationDTO;
import TrainingMug.Car.Management.DTO.CarResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarServiceInterface {
    CarResponseDTO createCar(CarRegistrationDTO carRegistrationDTO);
    CarResponseDTO getCarById(Long id);
    CarResponseDTO updateCar(CarRegistrationDTO carRegistrationDTO ,Long id);
    String deleteCar(Long id);
    Page<CarResponseDTO> ListOfCars(int page, int size, String field,String order);

    List<CarResponseDTO> searchCarByKeyword(String keyword);
}
