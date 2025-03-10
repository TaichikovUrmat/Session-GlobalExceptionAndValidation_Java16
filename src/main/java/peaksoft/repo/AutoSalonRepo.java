package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import peaksoft.entities.AutoSalon;

public interface AutoSalonRepo extends JpaRepository<AutoSalon, Long> {


}
