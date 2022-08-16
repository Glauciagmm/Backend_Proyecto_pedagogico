package com.uniquecare.pedagogico_backend.repositories;

import com.uniquecare.pedagogico_backend.models.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    List<Facility> findFacilitiesByCategoriesId(Long categoryId);
 List<Facility> findFacilitiesByCategoriesName(String categoryName);

 List<Facility>findFacilitiesByAssistant(Long assistantId);

//    List<Facility>findFacilitiesByUserId(Long userId);
    List<Facility> getContractByAssistantId(Long assistantId);
    //void removeFacilityFromContract(Long userId, Long facilityId);
}
