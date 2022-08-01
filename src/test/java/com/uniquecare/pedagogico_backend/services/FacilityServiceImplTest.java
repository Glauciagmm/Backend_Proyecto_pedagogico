package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;
import com.uniquecare.pedagogico_backend.repositories.FacilityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FacilityServiceImplTest {

    @Mock
    private FacilityRepository facilityRepository;

    private FacilityServiceImpl underTest;

    @BeforeEach
    void setUp(){
        underTest = new FacilityServiceImpl(facilityRepository);
    }

   @Test
    void addNewFacility() {

        Facility facility = new Facility(
                "Limpieza",
                "Limpieza de casa y jardines",
                15,
                "assistant"
        );
        underTest.addNewFacility(facility);
        ArgumentCaptor<Facility> facilityArgumentCaptor = ArgumentCaptor.forClass(Facility.class);
        verify(facilityRepository).save(facilityArgumentCaptor.capture());
        Facility capturedFacility = facilityArgumentCaptor.getValue();
        assertThat(capturedFacility).isEqualTo(facility);

    }

    @Test
    void getAllFacilities() {
        underTest.getAllFacilities();
        verify(facilityRepository).findAll();
    }

    @Test
    void findFacilityById() {
        Facility facility = new Facility(
                1L
        );
        given(facilityRepository.findById(facility.getId())).willReturn(Optional.of(facility));
        underTest.findFacilityById(facility.getId());
        verify(facilityRepository).findById(facility.getId());
    }

    @Test
    void deleteFacilityById() {
        Facility facility = new Facility(
                1L

        );
        underTest.deleteFacilityById(1L);
        verify(facilityRepository).deleteById(1L);

    }

   @Test
    private void updateFacility() {
        Facility facility = new Facility(
                "Limpieza",
                "Limpieza",
                15,
                "user"
                );
        underTest.updateFacility(facility);
        verify(facilityRepository).save(facility);
    }

    @Test
    void getAllFacilitiesByCategoryId() {
    }

    @Test
    void getAllFacilitiesByCategoryName() {
    }

    @Test
    void testDeleteFacilityById() {
    }

    @Test
    void getContractByUserID() {
    }
}