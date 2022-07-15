package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();

    User findById(Long id);

    User getUser(String username);

    void deleteUserById(Long id);

    User updateUser(User user);
}
