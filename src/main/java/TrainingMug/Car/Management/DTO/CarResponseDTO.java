package TrainingMug.Car.Management.DTO;

import TrainingMug.Car.Management.Util.FuelType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CarResponseDTO {
    private Long id;
    private String name;
    private String model;
    private Integer year;
    private Double price;
    private String color;
    @Enumerated(EnumType.STRING)
    private FuelType fueltype;
}
