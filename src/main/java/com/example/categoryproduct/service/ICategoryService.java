package com.example.categoryproduct.service;

import com.example.categoryproduct.model.Category;

import java.util.List;

public interface ICategoryService {
    boolean addCategory(Category category);

    void deleteCategoryById(Long categoryId);

    Category findCategoryById(Long categoryId);

    boolean updateCategory(Category category);

    List<Category> searchCategory(String keyword);

    Long getNewCategoryId();

}
