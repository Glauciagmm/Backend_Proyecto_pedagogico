package com.example.pedagogico_backend.repositories;

import com.example.pedagogico_backend.models.ERole;
import com.example.pedagogico_backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
