package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import peaksoft.entities.AutoSalon;
@Repository
public interface AutoSalonRepo extends JpaRepository<AutoSalon, Long> {


}
