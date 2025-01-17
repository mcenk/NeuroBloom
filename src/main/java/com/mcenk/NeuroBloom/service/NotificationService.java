package com.mcenk.NeuroBloom.service;


import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mcenk.NeuroBloom.model.Entry;
import com.mcenk.NeuroBloom.model.NotificationSchedule;
import com.mcenk.NeuroBloom.repository.NotificationRepository;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void createNotification(Entry entry) {

        try {
            List<Integer> natificationDays = List.of(1, 3, 5, 15, 30);

            for (int day : natificationDays) {
                NotificationSchedule notificationSchedule = new NotificationSchedule();

                notificationSchedule.setEntry(entry);
                notificationSchedule.setDay(day);
                notificationSchedule.setSent(false);
                notificationSchedule.setViewed(false);
                notificationSchedule.setScheduledTime(LocalDateTime.now().plusDays(day));

                notificationRepository.save(notificationSchedule);
            }
        }
        catch(Exception e) {
            throw new RuntimeException("Notification could not be created", e);

        }



        }
    }

