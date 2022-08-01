package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;

import java.util.List;

public interface IFacilityService {

    /** works*/
    List<Facility> getAllFacilities();
    List <Facility> getAllFacilitiesByCategoryId (Long categoryId);
    List <Facility> getAllFacilitiesByCategoryName (String categoryName);
    /** works*/
    Facility findFacilityById(Long id);
    //Facility addFacility(Facility facility);
    /** works*/
    Facility addNewFacility(Facility facility);
    /** works*/
    void deleteFacilityById(Long id);
    /** works*/
    Facility updateFacility(Facility facility);
    List <Facility> getContractByUserID (Long userId);

    //Facility addNewFacility(String title, String description, int pricePerHour, User assistant) throws Exception;


    //void removeFacilityFromContract (Long userId, Long facilityId);


}
