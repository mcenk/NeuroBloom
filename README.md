# NeuroBloom - İngilizce Öğrenme Uygulaması

## Proje Açıklaması
NeuroBloom, kullanıcıların İngilizce kelime öğrenme sürecini optimize eden ve aralıklı tekrar (spaced repetition) metodunu kullanan bir mobil uygulama backend sistemidir.

## Temel Özellikler
- Kullanıcılar yeni İngilizce kelimeleri anlamları ve örnek cümleleriyle birlikte kaydedebilir
- Sistem, kaydedilen kelimeler için aşağıdaki günlerde hatırlatma bildirimleri gönderir:
  - 1. gün
  - 3. gün
  - 5. gün
  - 15. gün
  - 30. gün
- Kullanıcı bildirimi görüntüleyip onayladığında, ilgili günün tekrarı tamamlanmış sayılır
- 30 günlük süreç tamamlandığında kelime "öğrenildi" olarak işaretlenir

## Teknik Detaylar
### API Endpoints
- `api/v1/entries`: GET, POST, PUT, DELETE için temel endpointtir. DELETE ve PUT için entryId gereklidir.
    
  - Kelime
  - Anlam
  - Örnek cümle(ler)
  - İlişkili kelimeler

### Veritabanı
- PostgreSQL

### Bildirim Sistemi
- Push notification sistemi ile kullanıcılara hatırlatmalar gönderilir
- Bildirimler belirlenen günlerde otomatik olarak tetiklenir
- Kullanıcı onayı ile tekrar tamamlanır

## Kelime Öğrenme Döngüsü
1. Kullanıcı yeni bir kelime kaydeder
2. Sistem belirlenen günlerde hatırlatma bildirimleri gönderir
3. Kullanıcı bildirimi görüntüler ve onaylar
4. 30 günlük süreç tamamlandığında kelime öğrenilmiş sayılır

## Gereksinimler
- Java 17+
- Spring Boot
- PostgreSQL
- Firebase Cloud Messaging (Push Notifications için) 