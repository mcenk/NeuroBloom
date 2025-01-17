package com.mcenk.NeuroBloom.model;

import java.util.Arrays;
import java.util.List;

public enum DefaultCategory {

    GENERAL("General"),
    WORK("Work"),
    PERSONAL("Personal"),
    ENGLISH("English"),
    HEALTH("Health"),
    FINANCES("Finances"),
    CODING("Coding"),
    AI("AI");

    private final String categoryName;

    DefaultCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return categoryName;

    }

    public static List<String> getDefaultCategories() {
        return Arrays.stream(DefaultCategory.values())
                .map(DefaultCategory::getName)
                .toList();
    }

}
