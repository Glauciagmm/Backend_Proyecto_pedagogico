package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Facilit;
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
class FacilitServiceImplTest {

    @Mock
    private FacilitRepository facilitRepository;
    private FacilitServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new FacilitServiceImpl(facilitRepository);

    }

    @Test
    void addFacilit() {
        Facilit facilit = new Facilit(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12

        );
        underTest.addFacilit(facilit);
        ArgumentCaptor<Facilit> facilitArgumentCaptor = ArgumentCaptor.forClass(Facilit.class);
        verify(facilitRepository).save(facilitArgumentCaptor.capture());
        Facilit capturedFacilit = facilitArgumentCaptor.getValue();
        assertThat(capturedFacilit).isEqualTo(facilit);

    }

    @Test
    void getAllFacilities() {
        underTest.getAllFacilities(pageable);
        verify(facilitRepository).findAll();
    }

    @Test
    void findFacilityById() {
        Facilit facilit = new Facilit(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12

        );
        given(facilitRepository.findById(facilit.getId())).willReturn(Optional.of(facilit));
        underTest.findFacilityById(facilit.getId());
        verify(facilitRepository).findById(facilit.getId());
    }


    @Test
    void deleteFacilitById() {
        Facilit facilit = new Facilit(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12

        );
        underTest.deleteFacilitById(1L);
        verify(facilitRepository).deleteById(1L);

    }

    @Test
    void updateFacilit() {
        Facilit facilit = new Facilit(
                1L,
                "Limpieza",
                "Limpieza de casa y jardines",
                12

        );
        underTest.updateFacilit(facilit);
        verify(facilitRepository).save(facilit);
    }
}