package peaksoft.repo.jdbcRepo;

import peaksoft.dto.response.GetAllAutoSalonResponse;

import java.util.List;

public interface AutoSalonJdbc {
    List<GetAllAutoSalonResponse> getAllAutoSalon();

    List<GetAllAutoSalonResponse> getAutoSalonById(Long id, int pageNumber, int pageSize);
}
