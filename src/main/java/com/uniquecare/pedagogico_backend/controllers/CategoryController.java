package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.Category;
import com.uniquecare.pedagogico_backend.models.Facility;
import com.uniquecare.pedagogico_backend.models.ResourceNotFoundException;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import com.uniquecare.pedagogico_backend.repositories.FacilityRepository;
import com.uniquecare.pedagogico_backend.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private FacilityRepository facilityRepository;
    private  final CategoryRepository categoryRepository;
    private  final CategoryServiceImpl categoryService;

    public CategoryController(CategoryRepository categoryRepository, CategoryServiceImpl categoryService){
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Category>> Category(Authentication authentication){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping("/create")
    public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category) {
        Category categorySaved = categoryService.addNewCategory(category);
        URI ubication = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categorySaved.getFacilities()).toUri();
        return ResponseEntity.created(ubication).body(categorySaved);
    }

    @GetMapping("/{id}")
    public  Category getCategoryById(@PathVariable Long id){
        return categoryService.getById(id);
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
