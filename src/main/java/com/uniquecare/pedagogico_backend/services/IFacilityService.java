package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Facility addFacility(Facility facility);
    List<Facility> getAllFacilities(Pageable pageable);
    Facility findFacilityById(Long id);

    List <Facility> getAllFacilitiesByCategoryId (Long categoryId);

    List <Facility> getAllFacilitiesByCategoryName (String categoryName);

    void deleteFacilityById(Long id);

    //List<Facilit> findFacilityByCategory(String categoryName);

    Facility updateFacility(Facility facility);
}
