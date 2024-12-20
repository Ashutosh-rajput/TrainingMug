package TrainingMug.Car.Management.DTO;

import TrainingMug.Car.Management.Util.FuelType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CarRegistrationDTO {
        @NotBlank
        private String name;
        @NotBlank
        private String model;
        @NotBlank
        private Integer year;
        @NotBlank
        private Double price;
        @NotBlank
        private String color;
        @NotBlank
        private FuelType fuelType;

}
