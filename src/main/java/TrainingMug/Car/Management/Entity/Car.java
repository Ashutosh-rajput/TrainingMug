package TrainingMug.Car.Management.Entity;

import TrainingMug.Car.Management.Util.FuelType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Transient;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name = "seq",sequenceName = "ex_seq",allocationSize = 1)
    private Long id;
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
