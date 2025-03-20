package peaksoft.service;

import peaksoft.dto.response.GetAllAutoSalonResponse;

import java.util.List;

public interface AutoSalonService {


    List<GetAllAutoSalonResponse> getAllAutoSalon();

    List<GetAllAutoSalonResponse> getAutoSalonById(Long autoSalonId, int pageNumber, int pageSize);
}
