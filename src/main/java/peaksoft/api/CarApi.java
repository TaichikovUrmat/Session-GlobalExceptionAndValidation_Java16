package peaksoft.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.AddCarRequest;
import peaksoft.dto.request.UpdateCarRequest;
import peaksoft.dto.response.GetAllCarResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entities.Car;
import peaksoft.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarApi {

    private final CarService carService;

    @Secured("OWNER")
    @PostMapping("/saveCar/{autoSalonId}")
    public SimpleResponse save(
            @PathVariable("autoSalonId") Long autoSalonId,
            @RequestBody @Valid AddCarRequest addCarRequest) {
        return carService.save(autoSalonId, addCarRequest);
    }

    @GetMapping("/getAllCars")
    public List<GetAllCarResponse> getAllCars() {
        return carService.fintAll();
    }


    @PutMapping("/update/{id}/{idAuto}")
    public SimpleResponse update(
            @PathVariable("id") Long id,
            @PathVariable("idAuto") Long idAuto,
            @RequestBody UpdateCarRequest updateCarRequest) {
        return carService.updateCar(id, idAuto, updateCarRequest);
    }

    @GetMapping("/findById/{id}")
    public Car findById(@PathVariable("id") Long id) {
        return carService.findById(id);
    }

    @DeleteMapping("/delete_car/{di}")
    public SimpleResponse delete(@PathVariable Long id) {
        return carService.deleteById(id);
    }

    @GetMapping("/findByName/{salonId}")
    public List<Car> findByName(@PathVariable Long salonId, @RequestParam String carMark) {
        return carService.findByCarName(salonId, carMark);
    }


}
