package com.uniquecare.pedagogico_backend.repositories;

import com.uniquecare.pedagogico_backend.models.Facilit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilitRepository extends JpaRepository<Facilit, Long> {
    List<Facilit> findAllByCategory(String categoryName);
}
