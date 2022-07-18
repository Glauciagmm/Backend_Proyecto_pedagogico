package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facilit;

import java.util.List;

public interface IFacilitService {
    Facilit addFacilit(Facilit facilit);
    List<Facilit> getAllFacilities();
    Facilit findFacilityById(Long id);
    void deleteFacilitById(Long id);

    //List<Facilit> findFacilityByCategory(String categoryName);

    Facilit updateFacilit(Facilit facilit);
}
