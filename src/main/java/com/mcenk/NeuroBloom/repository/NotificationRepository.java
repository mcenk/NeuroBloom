package com.mcenk.NeuroBloom.repository;

import com.mcenk.NeuroBloom.model.NotificationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationSchedule, Long> {
}
