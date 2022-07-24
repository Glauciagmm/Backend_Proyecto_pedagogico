package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facilit;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilitService {
    Facilit addFacilit(Facilit facilit);
    List<Facilit> getAllFacilities(Pageable pageable);
    Facilit findFacilityById(Long id);

    List <Facilit> getAllFacilitiesByCategoryId (Long categoryId);

    List <Facilit> getAllFacilitiesByCategoryName (String categoryName);

    void deleteFacilitById(Long id);

    //List<Facilit> findFacilityByCategory(String categoryName);

    Facilit updateFacilit(Facilit facilit);
}
