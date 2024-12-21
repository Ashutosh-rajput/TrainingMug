package TrainingMug.Car.Management.Repository;

import TrainingMug.Car.Management.Entity.Car;
import TrainingMug.Car.Management.Util.FuelType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepo extends JpaRepository<Car,Long> {
//    List<Car> findByfueltype(FuelType fueltype);
    Optional<Car> findByName(String name);
    Page<Car> findAll(Pageable pageable);
    @Query("SELECT p FROM Car p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.color) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.fueltype) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "CAST(p.year AS string) LIKE CONCAT('%', :keyword, '%') OR " +
            "LOWER(p.model) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Car> searchKeyword(String keyword);
}

