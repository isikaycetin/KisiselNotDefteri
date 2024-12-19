# KisiselNotDefteri

# Kişisel Not Defteri Uygulaması

Bu proje, kullanıcıların kişisel notlarını oluşturabileceği, düzenleyebileceği ve silebileceği bir *Kişisel Not Defteri* uygulamasıdır. Uygulama, *Java* dilinde geliştirilmiş ve *Swing* kullanılarak bir grafik kullanıcı arayüzü (GUI) sunmaktadır. Veritabanı işlemleri için *MySQL* kullanılmıştır.

---

## 📌 Proje Özellikleri

### Temel Özellikler
- *CRUD İşlemleri*:
  - Not Ekleme
  - Not Güncelleme
  - Not Silme
- Notların kategoriye göre filtrelenmesi.
- Kullanıcıya özel yetkilendirme:
  - *Admin Kullanıcı*:
    - Tüm kullanıcıların notlarını görüntüleyebilir ve yönetebilir.
  - *Normal Kullanıcı*:
    - Sadece kendi notlarını görüntüleyebilir ve yönetebilir.

### Kullanılan Tasarım Desenleri
- *Singleton*: Veritabanı bağlantısı için kullanıldı.
- *Factory*: Kullanıcı yetkilendirmesi için uygun DAO sınıfını oluşturmak amacıyla kullanıldı.
- *Observer*: Notlarda yapılan değişiklikleri takip etmek için kullanıldı.
- *State*: Notların durumlarına göre farklı işlemler gerçekleştirilmesini sağladı (örneğin: "Oluşturuldu", "Düzenleniyor", "Siliniyor").
- *Abstract Class*: Notların temel özelliklerini ve davranışlarını tanımlamak için kullanıldı.

---

## 🛠 Kullanılan Teknolojiler ve Araçlar

- *Java*: Projenin geliştirilmesi için.
- *Swing*: Grafik kullanıcı arayüzü oluşturmak için.
- *MySQL*: Veritabanı yönetimi için.
- *IntelliJ IDEA*: Geliştirme ortamı.
- *Git* ve *GitHub*: Proje versiyon kontrolü ve barındırma için.

---

## 🚀 Kurulum ve Çalıştırma

### Gerekli Yazılımlar
1. *Java JDK 11 veya üzeri*: [Java İndir](https://www.oracle.com/java/technologies/javase-downloads.html)
2. *MySQL*: [MySQL İndir](https://dev.mysql.com/downloads/)
3. *IntelliJ IDEA veya Eclipse*: [IntelliJ IDEA İndir](https://www.jetbrains.com/idea/)

### Adımlar
1. Bu projeyi GitHub'dan klonlayın:
   ```bash
   git clone https://github.com/kullanici-adiniz/kisisel-not-defteri.git
   cd kisisel-not-defteri
