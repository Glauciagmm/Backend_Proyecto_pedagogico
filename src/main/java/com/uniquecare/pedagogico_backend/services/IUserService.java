package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Contract;
import com.uniquecare.pedagogico_backend.models.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getUsers();
    Collection<User> setFacilityRole(String role);
    Optional<User> findByUsername(String username);
    void deleteUserById(Long id);
    User save(User user);
    User updateUser(User user);
    User getUserById(Long userId);
    Optional<User> getUserByUsername(String username);
    List<Contract> getContractByUserId(Long userId);
}
