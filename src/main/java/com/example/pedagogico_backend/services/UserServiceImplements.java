package com.example.pedagogico_backend.services;

import com.example.pedagogico_backend.domain.User;
import com.example.pedagogico_backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUser(String username) {
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



}
