package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facilit;
import com.uniquecare.pedagogico_backend.repositories.FacilitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class FacilitServiceImpl implements IFacilitService{

    private final FacilitRepository facilitRepository;

    @Override
    public Facilit addFacilit(Facilit facilit) {
        return facilitRepository.save(facilit);
    }

    @Override
    public List<Facilit> getAllFacilities() {
        return facilitRepository.findAll();
    }

    @Override
    public Facilit findFacilityById(Long id) {
        return facilitRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Servicio no encontrado"));
    }

    @Override
    public void deleteFacilitById(Long id) {
        facilitRepository.deleteById(id);
    }

    @Override
    public List<Facilit> getAllFacilitiesByCategory(String categoryName){
        return facilitRepository.findAllByCategory(categoryName);
    }

    @Override
    public Facilit updateFacilit(Facilit facilit) {
        return facilitRepository.save(facilit);
    }
}
