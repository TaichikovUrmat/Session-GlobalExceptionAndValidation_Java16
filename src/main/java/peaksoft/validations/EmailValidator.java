package peaksoft.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements ConstraintValidator<EmailValidation, String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        return email.length() > 11 && email.contains("@") && email.endsWith(".com");
        // @gmail.com
    }
}
