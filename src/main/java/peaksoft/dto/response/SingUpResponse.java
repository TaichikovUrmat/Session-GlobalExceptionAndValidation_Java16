package peaksoft.dto.response;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.HttpStatus;
import peaksoft.entities.Role;
import peaksoft.entities.User;
@Builder
public record SingUpResponse(
        String token,
        String email,
        Role role,
        String message,
        HttpStatus httpStatus


) {

}
