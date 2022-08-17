package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Contract;
import com.uniquecare.pedagogico_backend.models.ERole;
import com.uniquecare.pedagogico_backend.models.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    /** works*/
    List<User> getUsers();
   Collection<User> setFacilityRole(ERole role);
    Optional<User> findByUsername(String username);
    /** works*/
    void deleteUserById(Long id);
    User save(User user);
    /** works*/
    User updateUser(User user);
    User getUserById(Long userId);
    Optional<User> getUserByUsername(String username);
    List<Contract> getContractByUserId(Long userId);
    Optional<User> getUser(String username);
    /** works*/
    List<Contract> getContractByAssistantId(Long assistantId);
    User getByUsername(String username);

}
