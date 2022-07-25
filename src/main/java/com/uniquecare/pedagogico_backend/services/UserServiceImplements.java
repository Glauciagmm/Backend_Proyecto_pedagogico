package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplements implements IUserService {
    private final UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
     return userRepository.findById(userId).orElse(null);
     }

    @Override
    public Optional<User> getUserByUsername(String username) {
        log.info("Fetching user {}",  username);
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        log.info("Fetching user {}",  username);
        return userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }




    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


    public void getUser(String username) {
    }
}
