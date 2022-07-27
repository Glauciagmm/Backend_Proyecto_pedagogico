package com.uniquecare.pedagogico_backend.controllers;

import com.uniquecare.pedagogico_backend.models.Category;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Category>> Category(Authentication authentication, Pageable pageable){
        return ResponseEntity.ok(categoryRepository.findAll(pageable));
    }
    @PostMapping
    public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category) {
        Category categorySaved = categoryRepository.save(category);
        URI ubication = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categorySaved.getId()).toUri();
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

}
