package TrainingMug.Car.Management.DTO;

import TrainingMug.Car.Management.Util.FuelType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
        @NotNull
        private Integer year;
        @NotNull
        private Double price;
        @NotBlank
        private String color;

        @Enumerated(EnumType.STRING)
        private FuelType fueltype;

}
