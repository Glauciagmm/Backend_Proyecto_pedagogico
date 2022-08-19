package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Category;
import com.uniquecare.pedagogico_backend.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllFacilitiesByCategoriesName(String categoryName) {
        return null;
    }


    @Override
    public List<Category> getAllCategoriesByAssistantId(Long assistantId) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {
    categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
}
