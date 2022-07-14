package com.example.pedagogico_backend.services;

import com.example.pedagogico_backend.domain.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();

    User findById(Long id);

    User getUser(String username);

    void deleteUserById(Long id);

    User updateUser(User user);
}
