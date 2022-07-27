package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {


    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp(){ userRepository.deleteAll();}

    @Test
    void getUsers() {
    }

    @Test
    void updateUser() {
    }

   /* @Test
    RequestBuilder deleteUser(String users) throws Exception{
        User user = userRepository.save(new User(1L));
        mockMvc.perform(deleteUser("/user/" + user.getId())).andExpect(status().isOk());

     List<User> users = userRepository.findAll();
        assertThat (users, not(contains(allOf(
                hasProperty("id", is (1L))
               *//* hasProperty("name", is ("Glaucia")),
                hasProperty("username", is ("Mesquita")),
                hasProperty("email", is ("glau@glau.com")),
                hasProperty("city", is ("barcelona"))*//*
        ))));
        return null;
    }*/


}
