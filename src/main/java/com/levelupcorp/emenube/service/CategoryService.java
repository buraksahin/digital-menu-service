package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.Category;
import com.levelupcorp.emenube.domain.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(Long categoryId);
    List<Category> getByRestaurantId(Long restaurantId);
    Category createCategory(CategoryRequest categoryRequest);
    Category updateCategory(CategoryRequest categoryRequest, Long categoryId);
    Boolean deleteCategory(Long categoryId);
}
