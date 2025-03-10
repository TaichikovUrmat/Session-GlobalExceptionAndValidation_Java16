package peaksoft.service;

import peaksoft.dto.request.AddCarRequest;
import peaksoft.dto.request.UpdateCarRequest;
import peaksoft.dto.response.GetAllAutoSalon;
import peaksoft.dto.response.GetAllCarResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entities.Car;

import java.util.List;

public interface CarService {
    SimpleResponse save(Long autoSalonId,AddCarRequest addCarRequest );

    List<GetAllCarResponse> fintAll();

    SimpleResponse updateCar(Long id, Long idAvto, UpdateCarRequest updateCarRequest);

    Car findById(Long id);

    SimpleResponse deleteById(Long id);

    List<Car> findByCarName(Long salonId ,String carMark);

    List<GetAllAutoSalon> getAllAuto();
}
