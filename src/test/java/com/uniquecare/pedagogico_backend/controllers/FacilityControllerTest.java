package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.services.FacilityServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.allOf;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@AutoConfigureMockMvc
@WebAppConfiguration
@SpringBootTest
class FacilityControllerTest {

  /*  @Autowired
    private MockMvc mockMvc;*/

    //private final FacilityServiceImpl facilityService = Mockito.mock();

    @Test
    void findFacilityById() {
    }

  /*  @Test
    void getFacility() {
        try{
            mockMvc.perform(.get("/api/facility/list").accept(MediaType.APPLICATION_JSON)
                    .andExpect

        } catch (Exception e) {
            e.printStackTrace();
        }
        mockMvc.perform(get())
    }
    
    */

/*   @Test
    void addFacility() {
        Authentication authentication = new Authentication() {
            @Override
            public Object getPrincipal() {
                return null;
            }
        }
        Facility facility =
                new Facility(
                        "Viajes",
                        "Cuidado personal de personas dependentes",
                        20,
                        "Glaucia"

        );
        underTest.addFacility(facility);
    }*/

    @Test
    void editFacility() {
    }

    @Test
    void deleteFacilityById() {
    }
}

