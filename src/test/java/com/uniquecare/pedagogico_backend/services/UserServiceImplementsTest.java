package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplementsTest {

    @Mock
    private UserRepository userRepository;
    private UserServiceImplements underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserServiceImplements(userRepository);
    }

    @Test
    void getUserByUsername() {
        underTest.getUser("username");
        verify(userRepository).findByUsername("username");
    }

    @Test
    void getUsers() {
        underTest.getUsers();
        verify(userRepository).findAll();
    }

  /*  @Test
    void findById() {
        User user = new User(
                "Glau",
                "Glaucia",
                "Mesquita",
                "glaucia",
                "Glaucia@gmail.com",
                "123456789",
                [],
                "123789456"
        );
        underTest.updateUser(user);
        underTest.getUserById(1L);
        verify(userRepository).findById(1L);
    }
*/
    @Test
    void deleteUserById() {
        underTest.deleteUserById(1L);
        verify(userRepository).deleteById(1L);
    }
}