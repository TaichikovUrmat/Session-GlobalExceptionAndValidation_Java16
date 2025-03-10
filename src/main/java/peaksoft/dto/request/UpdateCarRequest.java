package peaksoft.dto.request;

import lombok.Builder;
import lombok.NonNull;

import java.time.LocalDate;
@Builder
public record UpdateCarRequest(
        @NonNull
        String marke,
        int price,
        LocalDate dateOfMade,
        String driver,
        String typ
) {
}
