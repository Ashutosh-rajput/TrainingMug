package TrainingMug.Car.Management.Repository;

import TrainingMug.Car.Management.Entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepo extends JpaRepository<Car,Long> {
    List<Car> findByFuelType(Long userId);
    Optional<Car> findByName(String name);
    Page<Car> findAll(Pageable pageable);
}

