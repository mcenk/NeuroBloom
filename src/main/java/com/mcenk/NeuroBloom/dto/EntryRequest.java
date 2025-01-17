package com.mcenk.NeuroBloom.dto;

import java.util.List;

public class EntryRequest {

    private String entry;
    private String description;
    private Long categoryId;

    public EntryRequest() {
    }

    public EntryRequest(String entry, String description, Long categoryId) {
        this.entry = entry;
        this.description = description;
        this.categoryId = categoryId;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
