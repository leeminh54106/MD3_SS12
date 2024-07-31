package com.example.categoryproduct.service.impl;

import com.example.categoryproduct.model.Category;
import com.example.categoryproduct.service.ICategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements ICategoryService {

    public static List<Category> categories = new ArrayList<>();

    static {
        categories.add(new Category("Áo", 1L, true));
        categories.add(new Category("Quần", 2L, true));
        categories.add(new Category("Dép", 3L, true));

    }

    @Override
    public boolean addCategory(Category category) {
       category.setCategoryId(getNewCategoryId());
       categories.add(category);
       return true;
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        int indexDelete = findIndexCategoryById(categoryId);
        categories.remove(indexDelete);
    }

    @Override
    public Category findCategoryById(Long categoryId) {
        if (findIndexCategoryById(categoryId) != -1) {
            return categories.get(findIndexCategoryById(categoryId));
        }
        return null;
    }

    public int findIndexCategoryById(Long categoryId) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCategoryId().equals(categoryId)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean updateCategory(Category category) {
        categories.set(findIndexCategoryById(category.getCategoryId()), category);
        return true;
    }

    @Override
    public List<Category> searchCategory(String keyword) {
        return categories.stream().filter(item -> item.getCategoryName().toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public Long getNewCategoryId() {
        Long maxId = 0L;
        for (Category category : categories) {
            if (category.getCategoryId() > maxId) {
                maxId = category.getCategoryId();
            }
        }
        return maxId + 1;
    }
}
