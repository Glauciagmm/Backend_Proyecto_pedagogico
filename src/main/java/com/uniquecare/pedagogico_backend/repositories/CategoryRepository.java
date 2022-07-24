package com.uniquecare.pedagogico_backend.repositories;

import com.uniquecare.pedagogico_backend.models.Category;

import com.uniquecare.pedagogico_backend.models.ECategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    List<Category> findCategoriesByFacilitiesId(Long facilityId);
}
