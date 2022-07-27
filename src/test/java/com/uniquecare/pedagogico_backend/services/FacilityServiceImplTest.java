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


    @Mock
    private FacilityRepository facilityRepository;
    private FacilityServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new FacilityServiceImpl(facilityRepository);

    }

    @Test
    void addFacility() {

        Facility facility = new Facility(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12,
                1
        );
        underTest.addFacility(facility);
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
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12,
                1L
        );
        underTest.deleteFacilityById(1L);
        verify(facilityRepository).deleteById(1L);

    }

    @Test
    void updateFacility() {
        Facility facility = new Facility(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12,
                1L
        );
        underTest.updateFacility(facility);
    }
        @Test
        void deleteFacilityById () {
            Facility facil = new Facility(
                    1L,
                    "Limpieza",
                    "Limpieza de casa y jardines",
                    10,
                    4L
            );
            underTest.deleteFacilityById(1L);
            verify(facilityRepository).deleteById(1L);
        }

        @Test
        void updateFacility () {
            Facility facilities = new Facility(
                    1L,
                    "Limpieza",
                    "Limpieza de casa y jardines",
                    10,
                    12

            );
            underTest.updateFacility(facility);
            verify(facilityRepository).save(facility);
        }
}