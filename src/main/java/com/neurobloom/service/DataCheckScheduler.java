// package com.neurobloom.service;

// import com.google.firebase.messaging.FirebaseMessaging;
// import com.google.firebase.messaging.Message;
// import com.google.firebase.messaging.Notification;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Service;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;

// @Service
// public class DataCheckScheduler {

//     private final YourDataService dataService; // Veri servisinizi buraya enjekte edin

//     public DataCheckScheduler(YourDataService dataService) {
//         this.dataService = dataService;
//     }

//     @Scheduled(cron = "0 0 8 * * *") // Her gün sabah 8'de çalışır
//     public void checkDailyData() {
//         LocalDate today = LocalDate.now();
//         String formattedDate = today.format(DateTimeFormatter.ISO_DATE);

//         // Servisinizden veriyi alın ve kontrol edin
//         boolean hasMatchingData = dataService.checkDataForDate(formattedDate);

//         if (hasMatchingData) {
//             sendPushNotification("Bugün için yeni veri mevcut!", 
//                                "Bugünün tarihiyle eşleşen yeni veriler bulundu.");
//         }
//     }

//     private void sendPushNotification(String title, String body) {
//         try {
//             Message message = Message.builder()
//                 .setNotification(Notification.builder()
//                     .setTitle(title)
//                     .setBody(body)
//                     .build())
//                 .setTopic("all_users") // Tüm kullanıcılara gönderir
//                 .build();

//             String response = FirebaseMessaging.getInstance().send(message);
//             System.out.println("Bildirim başarıyla gönderildi: " + response);
//         } catch (Exception e) {
//             System.err.println("Bildirim gönderilirken hata oluştu: " + e.getMessage());
//         }
//     }
// } 