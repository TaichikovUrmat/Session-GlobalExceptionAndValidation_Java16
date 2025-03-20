package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entities.User;
import peaksoft.exceptions.NotFoundException;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    default User findByUserEmail(String email) {
        return findByEmail(email).orElseThrow(()
                -> new NotFoundException("User not found with email: " + email));
    }
}
