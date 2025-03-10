package peaksoft.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented  // Означает, что аннотация будет видна в документации Javadoc.
@Constraint(validatedBy = {EmailValidator.class})  // Указывает, какой класс (EmailValidator) будет использоваться для валидации данных.
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValidation {

    String message() default "{email дын узундугуу - 11 жана @.com камтыш керек !! }";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
