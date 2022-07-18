package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getUsers();

    Optional<User> findByUsername(String username);

    void deleteUserById(Long id);

    User updateUser(User user);

    User getUserById(Long id);

    Optional<User> getUserByUsername(String username);
}
