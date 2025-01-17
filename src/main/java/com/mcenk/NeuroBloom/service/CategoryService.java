package com.mcenk.NeuroBloom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mcenk.NeuroBloom.model.Category;
import com.mcenk.NeuroBloom.repository.CategoryRepository;

import jakarta.annotation.PostConstruct;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    public Category createCategory(Category category) {
        if (categoryRepository.findByCategoryName(category.getCategoryName()).isPresent()) {
            throw new RuntimeException("Category already exists: " + category.getCategoryName());
        }
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category existingCategory = getCategoryById(id);
        
        // Eğer kategori adı değişiyorsa ve yeni ad zaten varsa hata fırlat
        if (!existingCategory.getCategoryName().equals(updatedCategory.getCategoryName()) &&
            categoryRepository.findByCategoryName(updatedCategory.getCategoryName()).isPresent()) {
            throw new RuntimeException("Category already exists: " + updatedCategory.getCategoryName());
        }
        
        existingCategory.setCategoryName(updatedCategory.getCategoryName());
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
    }
} 