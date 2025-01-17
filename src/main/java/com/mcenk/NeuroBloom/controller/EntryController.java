package com.mcenk.NeuroBloom.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.mcenk.NeuroBloom.dto.EntryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcenk.NeuroBloom.model.Entry;
import com.mcenk.NeuroBloom.service.EntryService;

@RestController
@RequestMapping("/api/v1/entries")
public class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping
    public ResponseEntity<List<Entry>> getAllEntries() {
        return ResponseEntity.ok(entryService.getAllEntries());
    }

    @PostMapping
    public ResponseEntity<Entry> createEntry(@RequestBody EntryRequest entryRequest) {
        return ResponseEntity.ok(entryService.createEntry(entryRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entry> updateEntry(@PathVariable Long id, @RequestBody Entry entry) {
        return ResponseEntity.ok(entryService.updateEntry(id, entry));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        entryService.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{entryId}/complete-reminder")
    public ResponseEntity<Entry> completeReminder(
            @PathVariable Long entryId,
            @RequestParam LocalDateTime reminderDate) {
        return ResponseEntity.ok(entryService.completeReminder(entryId, reminderDate));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Entry>> getActiveEntries() {
        return ResponseEntity.ok(entryService.getActiveEntries());
    }

    @GetMapping("/reminders")
    public ResponseEntity<List<Entry>> getEntriesForReminder(
            @RequestParam LocalDateTime reminderDate) {
        return ResponseEntity.ok(entryService.getEntriesForReminder(reminderDate));
    }
}
