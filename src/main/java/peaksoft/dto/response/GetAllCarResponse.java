package peaksoft.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class    GetAllCarResponse {
    private Long carId;
    private String marka;
    private int price;
    private LocalDate dateOfMade;
    private String driver;
    private String typ;

}
