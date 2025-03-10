package peaksoft.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
public class AddCarRequest {
    @NotBlank(message = "  не должен пустым")
    @Size(min = 2, max = 50,message = " марка должен содержать от 2 до 50")
    private String marke;
    
//    @Size(min = 1, max = 6000000, message = " price не должен быть отрецателный  ")
    @Min(message = "price не должен быть отрецателный ", value = 0L)
    private int  price;

    private LocalDate dateOfMade;
    @NotBlank(message = "  не должен пустым")
    private String driver;
    @NotBlank(message = "  не должен пустым")
    private String typ;
}
