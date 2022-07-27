package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;
import com.uniquecare.pedagogico_backend.repositories.FacilityRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FacilityServiceImplTest {


   /* @Mock
=======
    @Mock
>>>>>>> feature/test
    private FacilityRepository facilityRepository;
    private FacilityServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new FacilityServiceImpl(facilityRepository);

    }

<<<<<<< HEAD
    @Test
    void addFacilit() {
=======
   /* @Test
    void addFacility() {
>>>>>>> feature/test
        Facility facility = new Facility(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
<<<<<<< HEAD
                12,
                1

                );
        underTest.addFacilit(facility);
        ArgumentCaptor<Facility> facilitArgumentCaptor = ArgumentCaptor.forClass(Facility.class);
        verify(facilityRepository).save(facilitArgumentCaptor.capture());
        Facility capturedFacility = facilitArgumentCaptor.getValue();
        assertThat(capturedFacility).isEqualTo(facility);

    }

    @Test
    void getAllFacilities() {
        underTest.getAllFacilities(pageable);
        verify(facilityRepository).findAll();
    }

    @Test
=======
                12

        );
        underTest.addFacility(facility);
        ArgumentCaptor<Facility> facilityArgumentCaptor = ArgumentCaptor.forClass(Facility.class);
        verify(facilityRepository).save(facilityArgumentCaptor.capture());
        Facility capturedFacilit = facilityArgumentCaptor.getValue();
        assertThat(capturedFacilit).isEqualTo(facility);

    }
*/
   /* @Test
    void getAllFacilities() {
        underTest.getAllFacilities();
        verify(facilityRepository).findAll();
    }*/

  /*  @Test
>>>>>>> feature/test
    void findFacilityById() {
        Facility facility = new Facility(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
<<<<<<< HEAD
                12,

                role);
=======
                12

        );
>>>>>>> feature/test
        given(facilityRepository.findById(facility.getId())).willReturn(Optional.of(facility));
        underTest.findFacilityById(facility.getId());
        verify(facilityRepository).findById(facility.getId());
    }


    @Test
<<<<<<< HEAD
    void deleteFacilitById() {
        Facility facility = new Facility(
                 1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12,

                role);
        underTest.deleteFacilityById(1L);
        verify(facilityRepository).deleteById(1L);

    }

    @Test
    void updateFacilit() {
        Facility facility = new Facility(
                   1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12,

                role);
        underTest.updateFacilit(facility);
=======
    void deleteFacilityById() {
        Facility facility = new Facility(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12

        );
        underTest.deleteFacilityById(1L);
        verify(facilityRepository).deleteById(1L);

    }*/

   /* @Test
    void updateFacility() {
        Facility facility = new Facility(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12

        );
        underTest.updateFacility(facility);
>>>>>>> feature/test
        verify(facilityRepository).save(facility);
    }*/
}