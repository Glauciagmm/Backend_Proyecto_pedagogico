package com.uniquecare.pedagogico_backend.controllers;


import com.uniquecare.pedagogico_backend.repositories.UserRepository;import com.uniquecare.pedagogico_backend.security.WebSecurityConfig;
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
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import springfox.documentation.swagger.web.SecurityConfiguration;

import javax.annotation.PostConstruct;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Import(SecurityConfiguration.class)
@RunWith(SpringRunner.class)
class AuthControllerTest {

    MockMvc mockMvc;

    public AuthControllerTest(MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }

    @Autowired
    private UserRepository userRepository;

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
    @WithUserDetails(value = "username", userDetailsServiceBeanName = "userDetailsService")
    void authenticateUser() throws Exception {
        mockMvc.perform(
                get("/api/signin").secure(true)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void registerUser() {
    }
}