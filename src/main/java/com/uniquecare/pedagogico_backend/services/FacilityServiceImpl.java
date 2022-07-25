package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;
import com.uniquecare.pedagogico_backend.repositories.FacilityRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class FacilityServiceImpl implements IFacilityService {

    private final FacilityRepository facilityRepository;

    @Override
    public Facility addFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility findFacilityById(Long id) {
        return facilityRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Servicio no encontrado"));
    }

    @Override
    public void deleteFacilityById(Long id) {
        facilityRepository.deleteById(id);
    }

    /*@Override
    public List<Facilit> findFacilityByCategory(String categoryName){
        return facilitRepository.findAllByCategory(categoryName);
    }*/

    @Override
    public Facility updateFacility(Facility facility) {
        return facilityRepository.save(facility);
    }
}
