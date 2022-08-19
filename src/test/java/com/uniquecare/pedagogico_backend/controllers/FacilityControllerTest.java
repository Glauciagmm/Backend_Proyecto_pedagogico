package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.Facility;
import com.uniquecare.pedagogico_backend.repositories.FacilityRepository;
import com.uniquecare.pedagogico_backend.security.WebSecurityConfig;
import com.uniquecare.pedagogico_backend.security.services.UserDetailsImpl;

import com.uniquecare.pedagogico_backend.security.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import springfox.documentation.swagger.web.SecurityConfiguration;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Import(SecurityConfiguration.class)
@RunWith(SpringRunner.class)
class FacilityControllerTest {

    MockMvc mockMvc;

    public FacilityControllerTest(MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }

    @Autowired
    private FacilityRepository facilityRepository;

    @MockBean(name = "userDetailsImpl")
    private UserDetailsServiceImpl userDetailsService;

    @MockBean
    private WebSecurityConfig webSecurityConfig;

    @PostConstruct
    public void setup() {
        given(userDetailsService.loadUserByUsername(anyString()))
                .willReturn(new UserDetailsImpl());
    }

   @Test
    @WithMockUser
    public void test() throws Exception {
        mockMvc.perform(
                get("/signin").secure(true)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails(value = "username", userDetailsServiceBeanName = "userDetailsService")
    public void testAuthentication() throws Exception {
        mockMvc.perform(
                get("/pdps/authentication").secure(true)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @BeforeEach
    void setUp(){facilityRepository.deleteAll();}

    @Test
    void addFacility() throws Exception {

        mockMvc.perform(post("/api/facility/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Recados\"," +
                        "\"description\":\"Compras en supermercados, farmacias etc\"," +
                        "\"pricePerHour\":\"12\"}")
        ).andExpect(status().isOk());

       List<Facility> facility = facilityRepository.findAll();

        assertThat(facility, contains(allOf(
                hasProperty("title", is("Recados")),
                hasProperty("description", is("Compras en supermercados, farmacias etc")),
                hasProperty("pricePerHour", is("12"))

        )));
    }

    @Test
    void findFacilityById() throws Exception{
        Facility facility = facilityRepository.save(new Facility("limpieza", "Limpieza de Hograr y  jardines", 12));

        mockMvc.perform(get("api/facility/" + facility.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("Limpieza")))
                .andExpect(jsonPath("$.description", equalTo("Limpieza de Hograr y  jardines")))
                .andExpect(jsonPath("$.pricePerHour", equalTo(12)));

    }

    @Test
    void getFacility() throws Exception {

        sampleFacility();

        mockMvc.perform(get("/api/facility"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(1)))
                .andExpect(jsonPath("$[0].title", equalTo("Limpieza")))
                .andExpect(jsonPath("$[0].description", equalTo("Limpieza de Hograr y  jardines")))
                .andExpect(jsonPath("$[0].pricePerHour", equalTo(19)))
                .andDo(print());
    }

    /**Añade objetos al método que luego serán comprobados en el test getFacilitys*/
    private void sampleFacility() {
        List<Facility> facility = List.of(
                new Facility("Limpieza",
                       "Limpieza de Hograr y  jardines",
                       19));
        facilityRepository.saveAll(facility);
    }

    @Test
    void editFacility() {
    }

    @Test
    void deleteFacilityById() throws Exception{
        Facility facility = facilityRepository.save(new Facility("limpieza", "Limpieza de Hograr y  jardines", 12));

        mockMvc.perform(delete("/api/facility/"+ facility.getId()))
                .andExpect(status().isOk());

        List<Facility> facilities = facilityRepository.findAll();
        assertThat(facilities, not(contains(allOf(
                hasProperty("title", is("limpieza")),
                hasProperty("description", is("Limpieza de Hograr y  jardines"))
        ))));
    }
}