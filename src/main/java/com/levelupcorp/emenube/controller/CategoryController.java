package com.levelupcorp.emenube.controller;

import com.levelupcorp.emenube.domain.entity.Category;
import com.levelupcorp.emenube.domain.request.CategoryRequest;
import com.levelupcorp.emenube.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getCategory() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/get-by-category-id/{category-id}")
    public ResponseEntity<Category> getCategoryByCategoryId(@PathVariable("category-id") Long categoryId) {
        return ResponseEntity.ok(categoryService.getById(categoryId));
    }

    @GetMapping("/get-by-restaurant-id/{restaurant-id}")
    public ResponseEntity<List<Category>> getCategoryByRestaurantId(@PathVariable("restaurant-id") Long restaurantId) {
        return ResponseEntity.ok(categoryService.getByRestaurantId(restaurantId));
    }
    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        Category createdCategory = categoryService.createCategory(categoryRequest);
        return ResponseEntity.ok(createdCategory);
    }

    @PatchMapping("/update/{category-id}")
    public ResponseEntity<Category> updateCategory(@RequestBody @Valid CategoryRequest categoryRequest, @PathVariable("category-id") Long categoryId) {
        Category updatedCategory = categoryService.updateCategory(categoryRequest, categoryId);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/delete/{category-id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("category-id") @Valid Long categoryId) {
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }
}
