package peaksoft.dto.response;

import lombok.*;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
public class GetAllAutoSalon {

    private Long autoSalonId;
    private String name;
    private String address;
    private List<GetAllCarResponse> getAllCars;
}
