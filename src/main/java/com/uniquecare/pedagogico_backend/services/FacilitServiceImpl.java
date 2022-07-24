package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facilit;
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
    public Facilit addFacilit(Facilit facilit) {
        return facilitRepository.save(facilit);
    }

    @Override
    public List<Facilit> getAllFacilities(Pageable pageable) {
        return facilitRepository.findAll();
    }

    @Override
    public Facilit findFacilityById(Long id) {
        return facilitRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Servicio no encontrado"));
    }

    @Override
    public List<Facilit> getAllFacilitiesByCategoryId(Long categoryId) {
        return facilitRepository.findAllByCategoryId(categoryId);
    }
    @Override
    public List<Facilit> getAllFacilitiesByCategoryName(String categoryName) {
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
    public Facilit updateFacilit(Facilit facilit) {
        return facilitRepository.save(facilit);
    }
}
