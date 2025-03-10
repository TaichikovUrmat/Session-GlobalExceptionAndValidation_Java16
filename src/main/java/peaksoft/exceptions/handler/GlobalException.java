package peaksoft.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import peaksoft.exceptions.BadRequestException;
import peaksoft.exceptions.ForbiddenException;
import peaksoft.exceptions.NotFoundException;
import peaksoft.exceptions.response.ExceptionResponse;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    //404
    @ExceptionHandler(value = { NotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleNotFoundException(NotFoundException e) {
        return ExceptionResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(e.getMessage())
                .className(e.getClass().getSimpleName())
                .build();
    }

    @ExceptionHandler(value = { UsernameNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleUserNotFoundException(NotFoundException e) {
        return ExceptionResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(e.getMessage())
                .className(e.getClass().getSimpleName())
                .build();
    }


    //400
    @ExceptionHandler(value = { BadRequestException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleBadRequestException(BadRequestException e) {
        return ExceptionResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .className(e.getClass().getSimpleName())
                .build();
    }

    //403
    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse handleForbiddenException(ForbiddenException e) {
        return ExceptionResponse.builder()
                .status(HttpStatus.FORBIDDEN)
                .message(e.getMessage())
                .className(e.getClass().getSimpleName())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)  // Обрабатывает исключение типа MethodArgumentNotValidException
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {  // Метод для обработки ошибки

        Map<String, String> errors = new HashMap<>();  // Создаем Map для хранения ошибок
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {  // Перебираем все ошибки валидации полей
            errors.put(error.getField(), error.getDefaultMessage());  // Добавляем поле и сообщение об ошибке в Map
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);  // Возвращаем ошибки и статус 400 (BAD_REQUEST)
    }





}
