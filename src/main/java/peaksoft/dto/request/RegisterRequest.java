package peaksoft.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import peaksoft.entities.Role;
import peaksoft.validations.EmailValidation;

public record RegisterRequest(
//        @Email(message = "involit email")
//        @NotBlank(message = "не должен пустым")
//         @Pattern(
//                 regexp = ".*(gmail|@).*",
//                 message = "Email должен содержать 'gmail или !@")
        @EmailValidation
        String email,
        @Size(min = 7, max = 50,message = " password должен содержать от 7 до 50")
        String password,
        @NotBlank(message = "не должен пустым")
        @Size(min = 2,max = 100,message = " имя должен содержать от 2 до 100 символов")
        String name,
        Role role
) {
}
