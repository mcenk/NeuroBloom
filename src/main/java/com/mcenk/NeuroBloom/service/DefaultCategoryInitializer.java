package com.mcenk.NeuroBloom.service;

import com.mcenk.NeuroBloom.model.Category;
import com.mcenk.NeuroBloom.model.DefaultCategory;
import com.mcenk.NeuroBloom.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DefaultCategoryInitializer {

private final CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(DefaultCategoryInitializer.class);


    public DefaultCategoryInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @PostConstruct
    @Transactional

    public void initializeDefaultCategories() {
        List<String> defaultCategories = DefaultCategory.getDefaultCategories();

        defaultCategories.forEach(categoryName -> {

            if (categoryRepository.findByCategoryName(categoryName).isEmpty()) {
                Category category = new Category(categoryName);
                categoryRepository.save(category);
                logger.info("Default category '{}' added.", categoryName);

            }
        });
    }




}
