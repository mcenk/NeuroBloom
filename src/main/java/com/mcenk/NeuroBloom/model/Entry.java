package com.mcenk.NeuroBloom.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "entries")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String entry;

    @Column(nullable = false)
    private String description;



    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ElementCollection
    @CollectionTable(name = "reminder_dates", joinColumns = @JoinColumn(name = "entry_id"))
    private List<LocalDateTime> reminderDates;

    @ElementCollection
    @CollectionTable(name = "completed_reminders", joinColumns = @JoinColumn(name = "entry_id"))
    private List<LocalDateTime> completedReminders;

    private boolean isCompleted = false;

    // Constructors
    public Entry() {
    }

    public Entry(String entry, String description, LocalDateTime createdAt, List<LocalDateTime> reminderDates, List<LocalDateTime> completedReminders, boolean isCompleted) {
        this.entry = entry;
        this.description = description;
        this.createdAt = createdAt;
        this.reminderDates = reminderDates;
        this.completedReminders = completedReminders;
        this.isCompleted = isCompleted;
    }

    public Entry(Long id, String entry, String description, Category category, LocalDateTime createdAt, List<LocalDateTime> reminderDates, List<LocalDateTime> completedReminders, boolean isCompleted) {
        this.id = id;
        this.entry = entry;
        this.description = description;
        this.category = category;
        this.createdAt = createdAt;
        this.reminderDates = reminderDates;
        this.completedReminders = completedReminders;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<LocalDateTime> getReminderDates() {
        return reminderDates;
    }

    public void setReminderDates(List<LocalDateTime> reminderDates) {
        this.reminderDates = reminderDates;
    }

    public List<LocalDateTime> getCompletedReminders() {
        return completedReminders;
    }

    public void setCompletedReminders(List<LocalDateTime> completedReminders) {
        this.completedReminders = completedReminders;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // Getters and Setters


}
