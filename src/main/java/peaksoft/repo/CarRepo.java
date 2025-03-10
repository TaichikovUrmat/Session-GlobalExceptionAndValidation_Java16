package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import peaksoft.entities.Car;

public interface CarRepo extends JpaRepository<Car, Long> {

    @Query("select c from Car c where c.id =:id ")
    Car findByCarId(Long id);

    @Modifying
    @Query("delete from Car c where c.id = :id")
    Integer deleteCarById(Long id);
}
