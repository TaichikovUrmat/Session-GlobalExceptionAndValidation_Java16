package peaksoft.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetAllAutoSalonResponse {

     Long autoSalonId;
     String name;
     String address;
//    private Long carId;
//    private String marka;
//    private int price;
//    private LocalDate dateOfMade;
//    private String driver;
//    private String typ;

}
