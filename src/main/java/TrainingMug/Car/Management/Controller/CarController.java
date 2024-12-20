package TrainingMug.Car.Management.Controller;


import TrainingMug.Car.Management.DTO.CarRegistrationDTO;
import TrainingMug.Car.Management.DTO.CarResponseDTO;
import TrainingMug.Car.Management.Service.ServiceInterface.CarServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/Car")
public class CarController {

    @Autowired
    private CarServiceInterface carService;


    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("message","Welcome this endpoint is freeeee....");
        return "welcome";
    }

    @PostMapping("/create")
    @Operation(
            summary = "Register a new Car",
            description = "This endpoint allows registering a new car."
    )
    public ResponseEntity<CarResponseDTO> createCar(@RequestBody @Valid CarRegistrationDTO carRegistrationDTO) {
        log.info("New Car Creating.");
        CarResponseDTO carResponseDTO=carService.createCar(carRegistrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(carResponseDTO);
    }

    @GetMapping("/get/{id}")
    @Operation(
            summary = "Fetch car details by ID"
    )
    public ResponseEntity<CarResponseDTO> getCarById(@PathVariable Long id) {
        log.info("Fetching car details.");
        CarResponseDTO carResponseDTO=carService.getCarById(id);
        return ResponseEntity.status(HttpStatus.OK).body(carResponseDTO);
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Update Car details by Id."
    )
    public ResponseEntity<CarResponseDTO> updateCar(@RequestBody @Valid CarRegistrationDTO carRegistrationDTO, @PathVariable Long id) {
        log.info("Updating car details.");
        return ResponseEntity.ok(carService.updateCar(carRegistrationDTO,id));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Delete car details by Car Id."
    )
    public ResponseEntity<String> deleteCarById(@PathVariable Long id) {
        log.info("Deleting a car details.");
        carService.deleteCar(id);
        return ResponseEntity.ok("Car details deleted successfully with ID: " + id);
    }

    @GetMapping("/cars/{page}/{size}")
    @Operation(
            summary = "Get list of all cars stored in database."
    )
    public ResponseEntity<Page<CarResponseDTO>> getListOfCars(@PathVariable int page, @PathVariable int size) {
        log.info("Fetching list of cars.");
        return ResponseEntity.ok(carService.ListOfCars(page, size));
    }
}
