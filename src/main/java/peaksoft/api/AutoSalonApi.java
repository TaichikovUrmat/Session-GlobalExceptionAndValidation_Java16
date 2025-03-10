package peaksoft.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.dto.response.GetAllAutoSalon;
import peaksoft.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/auto")
@RequiredArgsConstructor
public class AutoSalonApi {


//    @Autowired
    private final CarService carService;



    @Secured("OWNER")
    @GetMapping("/getAllAuto")
    public List<GetAllAutoSalon> getAllAutoSalon() {
        return carService.getAllAuto();
    }


}
