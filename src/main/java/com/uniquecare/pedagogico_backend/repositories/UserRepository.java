package com.uniquecare.pedagogico_backend.repositories;

import java.util.Optional;

import com.uniquecare.pedagogico_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long userId);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User getByUsername (String username);
    User findUserById(Long id);
    User getUserByUsername(String username);
}
