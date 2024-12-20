package TrainingMug.Car.Management.DTO;

import TrainingMug.Car.Management.Util.FuelType;
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
    private FuelType fuelType;
}
