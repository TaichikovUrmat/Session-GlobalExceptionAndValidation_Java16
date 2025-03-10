package peaksoft.exceptions.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@Builder
public class ExceptionResponse {
    private HttpStatus status;
    private String message;
    private String className;
}
