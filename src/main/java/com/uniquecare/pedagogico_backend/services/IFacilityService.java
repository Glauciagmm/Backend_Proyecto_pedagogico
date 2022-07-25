package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;

import java.util.List;

public interface IFacilityService {
    Facility addFacility(Facility facility);
    List<Facility> getAllFacilities();
    Facility findFacilityById(Long id);
    void deleteFacilityById(Long id);

    //List<Facilit> findFacilityByCategory(String categoryName);

    Facility updateFacility(Facility facility);
}
