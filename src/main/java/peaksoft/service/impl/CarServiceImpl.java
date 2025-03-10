package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import peaksoft.dto.request.AddCarRequest;
import peaksoft.dto.request.UpdateCarRequest;
import peaksoft.dto.response.GetAllAutoSalon;
import peaksoft.dto.response.GetAllCarResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entities.AutoSalon;
import peaksoft.entities.Car;
import peaksoft.entities.User;
import peaksoft.exceptions.NotFoundException;
import peaksoft.repo.AutoSalonRepo;
import peaksoft.repo.CarRepo;
import peaksoft.repo.UserRepo;
import peaksoft.service.CarService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final AutoSalonRepo autoSalonRepo;
    private final CarRepo carRepo;
    private final UserRepo userRepo;

    @Override
    public SimpleResponse save(Long autoSalonId,AddCarRequest addCarRequest) {
        AutoSalon autoSalon = autoSalonRepo.findById(autoSalonId).orElseThrow(()
                -> new NotFoundException("not found auto salon id " + autoSalonId));
        Car car = new Car();
        car.setMarke(addCarRequest.getMarke());
        car.setPrice(addCarRequest.getPrice());
        car.setDriver(addCarRequest.getDriver());
        car.setTyp(addCarRequest.getTyp());
        car.setDateOfMade(addCarRequest.getDateOfMade());

        autoSalon.getCars().add(car);
        car.setAutoSalon(autoSalon);
        carRepo.save(car);

        return SimpleResponse.builder()
                    .message("Success saved auto salon")
                    .status(HttpStatus.OK)
                    .build();


    }

    @Override
    public List<GetAllCarResponse> fintAll() {
        List<Car> cars = carRepo.findAll();
        List<GetAllCarResponse> responses = new ArrayList<>();
        for (Car car : cars) {
            GetAllCarResponse build = GetAllCarResponse.builder()
                    .carId(car.getId())
                    .marka(car.getMarke())
                    .price(car.getPrice())
                    .driver(car.getDriver())
                    .typ(car.getTyp())
                    .build();
            responses.add(build);
        }
        return responses;
    }

    @Override
    public SimpleResponse updateCar(Long id, Long idAvto, UpdateCarRequest updateCarRequest) {
        AutoSalon autoSalon = autoSalonRepo.findById(idAvto).orElseThrow(() -> new RuntimeException("Auto salon not found"));
        Car car = null;
        if (autoSalon == null) {
            return SimpleResponse.builder()
                    .message("Auto salon not found")
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        for (Car car1 : autoSalon.getCars()) {
            if (car1.getId().equals(id)) {
                car = car1;
            }

        }
        if (car == null) {
            return SimpleResponse.builder()
                    .message("car not found")
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        car.setDriver(updateCarRequest.driver());
        car.setPrice(updateCarRequest.price());
        car.setMarke(updateCarRequest.marke());
        car.setTyp(updateCarRequest.typ());
        car.setDateOfMade(updateCarRequest.dateOfMade());
//        carRepo.save(car);
        return SimpleResponse
                .builder()
                .message("Car updated")
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public Car findById(Long id) {

        Car byCarId = carRepo.findByCarId(id);
        if (byCarId == null) {
            throw new RuntimeException("Car not found");
        }

        return byCarId;
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        Car car = carRepo.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        car.getAutoSalon().getCars().remove(car);
        car.setAutoSalon(null);
        boolean b = carRepo.deleteCarById(id) > 0;
        if (b) {
            return SimpleResponse.builder()
                    .message("car successfully deleted")
                    .status(HttpStatus.OK)
                    .build();
        }
        return SimpleResponse.builder()
                .message("Error on deleted!")
                .status(HttpStatus.CONFLICT)
                .build();
    }

    @Override
    public List<Car> findByCarName(Long salonId, String carMark) {
        AutoSalon autoSalon = autoSalonRepo.findById(salonId).orElseThrow(
                () -> new RuntimeException("Auto salon not found"));
        List<Car> cars = new ArrayList<>();
        for (Car car : autoSalon.getCars()) {
            if (car.getMarke().equals(carMark)) {
                cars.add(car);
            }
        }
        if (cars.isEmpty()) throw new RuntimeException("Car not found");
        return cars;

    }

    @Override
    public List<GetAllAutoSalon> getAllAuto() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found email ; " + email));
        AutoSalon autoSalon = user.getAutoSalon();
        if (autoSalon == null) {
            return Collections.emptyList();
        }
        List<GetAllCarResponse> carResponses = autoSalon.getCars().stream()
                .map(car -> GetAllCarResponse.builder()
                        .carId(car.getId())
                        .marka(car.getMarke())
                        .price(car.getPrice())
                        .driver(car.getDriver())
                        .typ(car.getTyp())
                        .build()).toList();

        return List.of(GetAllAutoSalon.builder()
                        .autoSalonId(autoSalon.getId())
                        .name(autoSalon.getName())
                        .address(autoSalon.getAddress())
                        .getAllCars(carResponses)
                .build());
    }

}
