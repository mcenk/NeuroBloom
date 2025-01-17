package com.mcenk.NeuroBloom.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class NotificationSchedule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entity_id", nullable = false)
    private Entry entry;

    private int day;
    private boolean sent;
    private boolean viewed;

    private LocalDateTime scheduledTime;
    // TODO sent time and viewed time will be added later


    public NotificationSchedule() {
    }

    public NotificationSchedule(Long id, Entry entry, int day, boolean sent, boolean viewed, LocalDateTime scheduledTime) {
        this.id = id;
        this.entry = entry;
        this.day = day;
        this.sent = sent;
        this.viewed = viewed;
        this.scheduledTime = scheduledTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}

