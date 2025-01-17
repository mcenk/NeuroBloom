package com.mcenk.NeuroBloom.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcenk.NeuroBloom.model.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByIsCompletedFalse();
    List<Entry> findByReminderDatesContaining(LocalDateTime reminderDate);
}
