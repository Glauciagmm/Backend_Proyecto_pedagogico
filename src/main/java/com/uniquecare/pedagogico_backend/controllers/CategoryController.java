package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.Category;
import com.uniquecare.pedagogico_backend.models.Facility;
import com.uniquecare.pedagogico_backend.models.ResourceNotFoundException;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.uniquecare.pedagogico_backend.repositories.FacilityRepository;
import com.uniquecare.pedagogico_backend.services.ICategoryService;
import com.uniquecare.pedagogico_backend.services.IFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="*")

@RequestMapping("/api/category")

public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Category>> Category(Authentication authentication){
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category) {
        Category categorySaved = categoryRepository.save(category);
        URI ubication = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categorySaved.getFacilities()).toUri();
        return ResponseEntity.created(ubication).body(categorySaved);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        Optional<Category> categoryOptional= categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(categoryOptional.get());

    }

    @GetMapping("/{categoryId}/facilities")
    public ResponseEntity<List<Facility>> getAllFacilitiesByCategoryId(@PathVariable(value = "categoryId") Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("Not found Tag  with id = " + categoryId);
        }
        List<Facility> facilities = facilityRepository.findFacilitiesByCategoriesId(categoryId);
        return new ResponseEntity<>(facilities, HttpStatus.OK);
    }

}
