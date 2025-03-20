package peaksoft.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.response.GetAllAutoSalon;
import peaksoft.dto.response.GetAllAutoSalonResponse;
import peaksoft.service.AutoSalonService;
import peaksoft.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/auto")
@RequiredArgsConstructor
public class AutoSalonApi {

//    @Autowired
    private final CarService carService;
    private final AutoSalonService autoSalonService;

    @Secured("OWNER")
    @GetMapping("/getAllAuto")
    public List<GetAllAutoSalonResponse> getAllAutoSalon() {
        return autoSalonService.getAllAutoSalon();
    }

    @Secured("OWNER")
    @GetMapping("/getAllAutoSalon/{autoSalonId}")
    public List<GetAllAutoSalonResponse> getAllAutoSalonById(
            @PathVariable("autoSalonId") Long autoSalonId,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return autoSalonService.getAutoSalonById(autoSalonId,pageNumber,pageSize);
    }




}
