package com.uniquecare.pedagogico_backend.services;

import com.uniquecare.pedagogico_backend.models.Category;
import com.uniquecare.pedagogico_backend.models.Facility;

import java.util.List;

public interface ICategoryService {
    /** works*/
    List<Category> getAllCategories();
    /** works*/
    Category getById(Long id);
    /** works*/
    Category addNewCategory(Category category);
    /** works*/
    List <Category> getAllFacilitiesByCategoriesName(String categoryName);
    List <Category> getAllCategoriesByAssistantId(Long assistantId);
    void deleteCategoryById(Long id);
    /** works*/
    Category updateCategory(Category category);


}
