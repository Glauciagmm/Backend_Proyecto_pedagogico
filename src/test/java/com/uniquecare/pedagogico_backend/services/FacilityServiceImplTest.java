package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facility;
import com.uniquecare.pedagogico_backend.repositories.FacilitRepository;

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
    private FacilitRepository facilitRepository;
    private FacilitServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new FacilitServiceImpl(facilitRepository);

    }

    @Test
    void addFacilit() {
        Facility facility = new Facility(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12,
                1

                );
        underTest.addFacilit(facility);
        ArgumentCaptor<Facility> facilitArgumentCaptor = ArgumentCaptor.forClass(Facility.class);
        verify(facilitRepository).save(facilitArgumentCaptor.capture());
        Facility capturedFacility = facilitArgumentCaptor.getValue();
        assertThat(capturedFacility).isEqualTo(facility);

    }

    @Test
    void getAllFacilities() {
        underTest.getAllFacilities(pageable);
        verify(facilitRepository).findAll();
    }

    @Test
    void findFacilityById() {
        Facility facility = new Facility(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12,

                role);
        given(facilitRepository.findById(facility.getId())).willReturn(Optional.of(facility));
        underTest.findFacilityById(facility.getId());
        verify(facilitRepository).findById(facility.getId());
    }


    @Test
    void deleteFacilitById() {
        Facility facility = new Facility(
                 1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12,

                role);
        underTest.deleteFacilitById(1L);
        verify(facilitRepository).deleteById(1L);

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
        verify(facilitRepository).save(facility);
    }
}