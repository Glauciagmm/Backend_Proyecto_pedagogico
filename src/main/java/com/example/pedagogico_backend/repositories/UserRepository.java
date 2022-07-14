package com.example.pedagogico_backend.repositories;

import com.example.pedagogico_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
    User findUserById(Long id);
}
