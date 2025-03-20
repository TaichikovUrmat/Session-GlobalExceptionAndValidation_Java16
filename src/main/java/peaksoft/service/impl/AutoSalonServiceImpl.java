package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.response.GetAllAutoSalonResponse;
import peaksoft.entities.AutoSalon;
import peaksoft.exceptions.NotFoundException;
import peaksoft.repo.AutoSalonRepo;
import peaksoft.repo.jdbcRepo.AutoSalonJdbc;
import peaksoft.service.AutoSalonService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoSalonServiceImpl implements AutoSalonService {

    private final AutoSalonRepo autoSalonRepo;
    private final AutoSalonJdbc autoSalonJdbc;



    @Override
    public List<GetAllAutoSalonResponse> getAllAutoSalon() {
        return autoSalonJdbc.getAllAutoSalon();
    }

    @Override
    public List<GetAllAutoSalonResponse> getAutoSalonById(Long autoSalonId, int pageNumber, int pageSize) {
        AutoSalon autoSalon = autoSalonRepo.findById(autoSalonId).orElseThrow(() -> new NotFoundException("not found auto salon id : " + autoSalonId));
        return autoSalonJdbc.getAutoSalonById(autoSalon.getId(),pageNumber,pageSize);
    }
}
