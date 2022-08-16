package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.Facility;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;
import com.uniquecare.pedagogico_backend.repositories.FacilityRepository;
import com.uniquecare.pedagogico_backend.repositories.RoleRepository;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import com.uniquecare.pedagogico_backend.services.FacilityServiceImpl;
import com.uniquecare.pedagogico_backend.services.IFacilityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FacilityControllerTest {

    @Mock
    private FacilityController underTest;
    private IFacilityService facilityService;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @BeforeEach
    void setUp(){
        underTest = new FacilityController (facilityService, categoryRepository, userRepository, roleRepository);
    }

    @Test
    void findFacilityById() {
    }

    @Test
    void getFacility() {
    }

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