package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.Category;
import com.levelupcorp.emenube.domain.request.CategoryRequest;
import com.levelupcorp.emenube.repository.CategoryRepository;
import com.levelupcorp.emenube.util.mapper.GenericMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    private GenericMapper genericMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, GenericMapper genericMapper) {
        this.categoryRepository = categoryRepository;
        this.genericMapper = genericMapper;
    }


    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long categoryId) {
        return categoryRepository.findById(categoryId).map(category -> category).orElse(null);
    }

    @Override
    public List<Category> getByRestaurantId(Long restaurantId) {
        return categoryRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        Category newCategory = new Category();
        BeanUtils.copyProperties(categoryRequest, newCategory);
        Category savedCategory = categoryRepository.save(newCategory);
        return savedCategory;
    }

    @Override
    public Category updateCategory(CategoryRequest categoryRequest, Long categoryId) {
        Category currentCategory = categoryRepository.findById(categoryId).map(category->category).orElse(null);

        if(currentCategory == null){
            return null;
        }
        try {
            genericMapper.<CategoryRequest, Category>copyProperties(categoryRequest, currentCategory);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Category savedCategory = categoryRepository.save(currentCategory);
        return savedCategory;
    }

    @Override
    public Boolean deleteCategory(Long categoryId) {
        return null;
    }
}
