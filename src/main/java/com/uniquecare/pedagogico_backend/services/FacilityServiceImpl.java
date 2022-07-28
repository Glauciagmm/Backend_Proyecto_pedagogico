package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;
import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;
import com.uniquecare.pedagogico_backend.repositories.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class FacilityServiceImpl implements IFacilityService {

    @Autowired
    private final FacilityRepository facilityRepository;
    @Autowired
    private final CategoryRepository categoryRepository;
     @Autowired

     private final UserServiceImplements userServiceImplements;


    @Override
    public Facility addFacility(Facility facility) {
        User user= (User) userServiceImplements.setFacilityRole("ROLE_FACILITY");
        user.setFacility((List<Facility>) facility);
        User user_assistant =facility.getAssistant();
        facility.setAssistant(user_assistant);
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
    public List<Facility> getAllFacilitiesByCategoriesId(Long categoryId) {
        return facilityRepository.findFacilitiesByCategoriesId(categoryId);
    }


    @Override
    public void deleteFacilityById(Long id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Facility updateFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public List<Facility> getContractByUserID(Long userId) {
        return null;
        //return facilityRepository.getContractById(userId);

         /* @Override
    public void removeFacilityFromContract(Long userId, Long facilityId) {
        facilityRepository.removeFacilityFromContract(userId, facilityId);
    }*/
    }
}
