package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IFacilityService {

    List<Facility> getAllFacilities();
    List <Facility> getAllFacilitiesByCategoryId (Long categoryId);
    List <Facility> getAllFacilitiesByCategoryName (String categoryName);
    Facility findFacilityById(Long id);
    Facility addFacility(Facility facility);
    void deleteFacilityById(Long id);
    Facility updateFacility(Facility facility);
    List <Facility> getContractByUserID (Long userId);

    //void removeFacilityFromContract (Long userId, Long facilityId);


}
