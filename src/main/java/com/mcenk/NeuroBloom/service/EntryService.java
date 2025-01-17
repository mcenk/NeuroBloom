package com.mcenk.NeuroBloom.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mcenk.NeuroBloom.dto.EntryRequest;
import com.mcenk.NeuroBloom.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mcenk.NeuroBloom.model.Entry;
import com.mcenk.NeuroBloom.repository.EntryRepository;

@Service
public class EntryService {

    private static final Logger log = LoggerFactory.getLogger(EntryService.class);
    private final EntryRepository entryRepository;

    private final CategoryService categoryService;

    public EntryService(EntryRepository entryRepository, CategoryService categoryService) {

        this.entryRepository = entryRepository;
        this.categoryService = categoryService;
    }

    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    public Entry createEntry(EntryRequest entryRequest) {
        Category category = categoryService.getCategoryById(entryRequest.getCategoryId());

        Entry entry = new Entry();
        entry.setEntry(entryRequest.getEntry());
        entry.setDescription(entryRequest.getDescription());
        entry.setCategory(category);

        entry.setCreatedAt(LocalDateTime.now());
        entry.setCompleted(false);
        
        // Hatırlatma tarihlerini ayarla
        List<Integer> reminderDays = Arrays.asList(1, 3, 5, 15, 30);
        List<LocalDateTime> reminderDates = new ArrayList<>();
        
        for (Integer day : reminderDays) {
            reminderDates.add(entry.getCreatedAt().plusDays(day));
        }
        
        entry.setReminderDates(reminderDates);
        entry.setCompletedReminders(new ArrayList<>());

        return entryRepository.save(entry);
    }

    public Entry updateEntry(Long id, Entry updatedEntry) {
        Entry existingEntry = entryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
                

                existingEntry.setEntry(updatedEntry.getEntry());
                existingEntry.setDescription(updatedEntry.getDescription());

        return entryRepository.save(existingEntry);
    }

    public void deleteEntry(Long id) {
        

        Entry entry = entryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found"));
        entryRepository.delete(entry);
    }

    public Entry completeReminder(Long entryId, LocalDateTime reminderDate) {
        Entry entry = entryRepository.findById(entryId)
                .orElseThrow(() -> new RuntimeException("Entry not found"));

        List<LocalDateTime> completedReminders = entry.getCompletedReminders();
        completedReminders.add(reminderDate);
        entry.setCompletedReminders(completedReminders);

        // Tüm hatırlatmalar tamamlandıysa
        if (completedReminders.size() >= 5) {
            entry.setCompleted(true);
        }

        return entryRepository.save(entry);
    }

    public List<Entry> getActiveEntries() {
        return entryRepository.findByIsCompletedFalse();
    }

    public List<Entry> getEntriesForReminder(LocalDateTime reminderDate) {
        return entryRepository.findByReminderDatesContaining(reminderDate);
    }
}
