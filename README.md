## Proje Ekibi
*https://github.com/isikaycetin/KisiselNotDefteri* <div></div>
https://github.com/YildirayParlak/KisiselNotDefteri/tree/main*
# Kişisel Not Defteri Uygulaması

Bu proje, kullanıcıların kişisel notlarını oluşturabileceği, düzenleyebileceği,silebileceği ve kategorize edebileceği bir *Kişisel Not Defteri* uygulamasıdır. Uygulama, *Java* dilinde geliştirilmiş ve *Swing* kullanılarak bir grafik kullanıcı arayüzü (GUI) sunmaktadır. Veritabanı işlemleri için *MySQL* kullanılmıştır.


## 📌 Proje Özellikleri

### Temel Özellikler
- *CRUD İşlemleri*:
  - Not Ekleme
  - Not Güncelleme
  - Not Silme
  - Notların kategoriye göre filtrelenmesi.
  - Her not, bir veya daha fazla etiketle ilişkilendirilebilir.
- Kullanıcıya özel yetkilendirme:
  - *Admin Kullanıcı*:
    - Tüm kullanıcıların notlarını görüntüleyebilir ve yönetebilir ama hangi kullanıcı olduğunu göremez.
  - *Normal Kullanıcı*:
    - Sadece kendi notlarını görüntüleyebilir ve yönetebilir.

### Kullanılan Tasarım Desenleri
- *Singleton*: Veritabanı bağlantısı için kullanıldı.
- *Factory*: Kullanıcı yetkilendirmesi için uygun DAO sınıfını oluşturmak amacıyla kullanıldı.
- *Observer*: Notlarda yapılan değişiklikleri takip etmek için kullanıldı.
- *State*: Notların durumlarına göre farklı işlemler gerçekleştirilmesini sağladı (örneğin: "Oluşturuldu", "Düzenleniyor", "Siliniyor").
- *Decorator*- Not objelerine etiket eklemek ve onları modifiye etmek için kullanılır.
- *Abstract Class*: Notların temel özelliklerini ve davranışlarını tanımlamak için kullanıldı.

# Kullanılan Sayfalar

- **Database Connection Sınıfı (Singleton Deseni)**: Veritabanı bağlantısını yöneten ve yalnızca bir bağlantının oluşmasını sağlayan Singleton deseni kullanılarak oluşturulmuş sınıf.
- **Observer**: Bildirimleri almak için kullanılan ve belirli bir olay olduğunda tetiklenen, diğer sınıflardan veri alan arayüz.
- **Observable**: Observer'lara mesaj gönderen ve onların güncellenmesini sağlayan sınıf, gözlemlenen nesnenin durumunu takip eder.
- **NotDAO**: Not verilerinin veritabanı işlemleri (ekleme, silme, güncelleme) ile yönetilmesini sağlayan soyut sınıf.
- **BaseNot**: Ortak not özelliklerini (başlık, içerik, tarih, kullanıcı id vb.) tutan ve alt sınıflarına genel veri yapısını sağlayan soyut sınıf.
- **Not**: BaseNot sınıfından türeyen ve ek olarak etiketler, kategori gibi özellikleri barındıran, notların detaylarını yöneten sınıf.
- **NotDecorator**: Mevcut notları süsleyerek yeni özellikler ekleyen tasarım deseni olan Decorator'ı implement eden sınıf.
- **NotDefteriUI**: Kullanıcı arayüzünü sağlayan ve notlarla ilgili işlemleri (ekleme, silme, güncelleme, filtreleme) kullanıcıya sunan sınıf.
- **RegisterUI**: Kullanıcının sisteme kayıt olmasını sağlayan arayüz, kullanıcı adı ve şifre alır.
- **RegularUserDAO**: Normal kullanıcıların notlarını yönetmek için NotDAO sınıfını implement eden ve veritabanından notları çeken sınıf.
- **AdminUserDAO**: Admin kullanıcılarının notlarını yönetmek için NotDAO sınıfını implement eden ve veritabanından admin notlarını çeken sınıf.
- **LoginUI**: Kullanıcıların giriş yapabilmesi için arayüz sağlayan sınıf, kullanıcı adı ve şifre ile doğrulama yapar.
- **NotDAOFactory**: Kullanıcı türüne göre (admin ya da normal kullanıcı) doğru NotDAO sınıfını oluşturan fabrika sınıfı.


## 🛠 Kullanılan Teknolojiler ve Araçlar

- *Java*: Projenin geliştirilmesi için.
- *Swing*: Grafik kullanıcı arayüzü oluşturmak için.
- *MySQL*: Veritabanı yönetimi için.
- *IntelliJ IDEA*: Geliştirme ortamı.
- *Git* ve *GitHub*: Proje versiyon kontrolü ve barındırma için.


