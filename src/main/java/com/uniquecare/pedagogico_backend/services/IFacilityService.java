package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;

import java.util.List;

public interface IFacilityService {

    Facility addFacility(Facility facility);
    Facility addNewFacility(Facility facility);

    List<Facility> getAllFacilities();
     List <Facility> getAllFacilitiesByCategoriesId(Long categoryId);

    List <Facility> getAllFacilitiesByCategoriesName(String categoryName);

//    List <Facility> getAllFacilitiesByUserId(Long userId);

    List <Facility> getAllFacilitiesByAssistantId(Long assistantId);
    Facility findFacilityById(Long id);

    void deleteFacilityById(Long id);
    Facility updateFacility(Facility facility);
    //List <Facility> getContractByUserID (Long userId);

    //void removeFacilityFromContract (Long userId, Long facilityId);


}
