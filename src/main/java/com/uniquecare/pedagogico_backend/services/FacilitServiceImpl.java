package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;
import com.uniquecare.pedagogico_backend.repositories.FacilitRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class FacilitServiceImpl implements IFacilitService{

    private final FacilitRepository facilitRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Facility addFacilit(Facility facility) {
        return facilitRepository.save(facility);
    }

    @Override
    public List<Facility> getAllFacilities(Pageable pageable) {
        return facilitRepository.findAll();
    }

    @Override
    public Facility findFacilityById(Long id) {
        return facilitRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Servicio no encontrado"));
    }

    @Override
    public List<Facility> getAllFacilitiesByCategoryId(Long categoryId) {
        return facilitRepository.findAllByCategoryId(categoryId);
    }
    @Override
    public List<Facility> getAllFacilitiesByCategoryName(String categoryName) {
        return facilitRepository.findAllByCategoryName(categoryName);
    }

    @Override
    public void deleteFacilitById(Long id) {
        facilitRepository.deleteById(id);
    }

/*    @Override
    public List<Facilit> getAllFacilitiesByCategory(String categoryName){
        categoryName = categoryRepository.findByName(ECategory name);
        return facilitRepository.findAllByCategory(categoryName);
    }*/

    @Override
    public Facility updateFacilit(Facility facility) {
        return facilitRepository.save(facility);
    }
}
