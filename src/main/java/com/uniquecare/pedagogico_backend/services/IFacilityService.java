package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;
import java.util.List;

public interface IFacilityService {

    /** works*/
    List<Facility> getAllFacilities();
    /** works*/
    Facility findFacilityById(Long id);
    /** works*/
    Facility addNewFacility(Facility facility);
    /** works*/
    List<Facility> getAllFacilitiesByCategoriesId(Long categoryId);
    List <Facility> getAllFacilitiesByCategoriesName(String categoryName);
    List <Facility> getAllFacilitiesByAssistantId(Long assistantId);
    void deleteFacilityById(Long id);
    /** works*/
    Facility updateFacility(Facility facility);
    List <Facility> getContractByUserID (Long userId);
}
