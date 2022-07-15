package com.uniquecare.pedagogico_backend.security.services;

import com.uniquecare.pedagogico_backend.models.Role;
import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.repositories.RoleRepository;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private RoleRepository roleRepository;

    private UserDetailsServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserDetailsServiceImpl(userRepository, passwordEncoder, roleRepository);
    }

    @Test
    void loadUserByUsername() {
        User user = new User(
                1L,
                "glau",
                "glau",
                "glau@gmail.com",
                "BCN"
        );
        Role role = new Role(1L, "ROLE_ADMIN");
        user.getRoles().add(role);

        given(userRepository.findByUsername("glau")).willReturn(Optional.of(user));

        underTest.loadUserByUsername("glau");
        verify(userRepository).findByUsername("glau");

    }
}