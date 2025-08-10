# Corporate Management System 

## 📌 Proje Amacı
Bu projenin temel amacı, bir şirketin **çalışanlarını ve departmanlarını etkin bir şekilde yönetebileceği**, **rol tabanlı yetkilendirme** ile güvenli bir web uygulaması geliştirmektir.  
Bu proje, **Spring Boot ekosistemi** kullanılarak; REST API geliştirme, ilişkisel veritabanı yönetimi, JWT tabanlı güvenlik, API dokümantasyonu ve temiz kod prensiplerini uygulama gibi konularda deneyim kazanmak için hazırlanmıştır.

---

## 🎯 Proje Hedefleri
1. **İlişkisel Veritabanı Tasarımı ve Uygulaması**
   - Company, User ve Department gibi varlıklar arasında doğru ilişkilerin kurulması.
   - `@OneToMany`, `@ManyToOne` gibi JPA anotasyonlarının doğru kullanımı.

2. **RESTful API Geliştirme**
   - HTTP metodlarına uygun (GET, POST, PUT, DELETE) endpoint tasarımı.
   - Richardson Maturity Model prensiplerine uygun kaynak yönetimi.

3. **JWT ile Güvenlik**
   - Kullanıcı kimlik doğrulama (Authentication).
   - Rol tabanlı yetkilendirme (Authorization).

4. **API Dokümantasyonu**
   - Swagger/OpenAPI entegrasyonu ile otomatik API belgeleri.

5. **Kod Kalitesi ve Git Yönetimi**
   - Temiz kod prensiplerine uygun geliştirme.
   - Anlamlı ve açıklayıcı commit mesajları.

---

## 🏗 Temel Fonksiyonellikler (Rol Bazlı)
- **ADMIN**
  - Sistemde tam yetkilidir.
  - Yeni company oluşturma, silme, tüm şirketleri listeleme ve detaylarını görme.
  - Kullanıcı ekleme, güncelleme, silme, tüm kullanıcıları listeleme.
  - Departman ekleme, güncelleme, silme, tüm departmanları listeleme ve detaylarını görme.

- **Company Yönetimi**
  - Company oluşturma  → Sadece ADMIN
  - Company silme → Sadece ADMIN
  - Company listeleme ve detay görüntüleme → Tüm roller

- **User Yönetimi** 
  - Kayıt olma 
  - Giriş yapma 
  - Kullanıcı ekleme/güncelleme/silme → ADMIN ve HUMAN_RESOURCE
  - Listeleme ve detay görüntüleme → Rol bazlı erişim

- **Department Yönetimi**
  - Departman ekleme/güncelleme/silme → ADMIN ve HUMAN_RESOURCE
  - Departman listeleme ve detay görüntüleme → Tüm roller

---

## 🗄 Kullanılan Teknolojiler
- **Java 19** 
- **Spring Web** 
- **Spring Security + JWT**
- **Spring Data JPA (H2 Database - In-memory)**
- **Lombok**
- **Swagger / OpenAPI**
- **Apache Maven** 

---

## 📂 Proje Klasör Yapısı
```
sprinfboot/
    src/
        main/
            java/com/example/corporateapp/
                CorporateAppApplication.java   # Ana uygulama sınıfı
                config/                        # Güvenlik yapılandırmaları
                controller/                    # REST API Controller'ları
                dto/                           # Veri Transfer Nesneleri
                exception/                     # Global hata yönetimi
                model/                         # Entity sınıfları
                repository/                    # JPA Repository'ler
                security/                      # JWT servisleri ve filtreleri
                service/                       
                    impl/                      # Service implementasyonları
            resources/
                application.properties         # Proje yapılandırma dosyası
```

---

## ⚙️ Projeyi Oluşturma (start.spring.io)
Projeyi oluşturmak için [Spring Initializr](https://start.spring.io/) sitesine gidin ve şu adımları izleyin:
1. **Project**: Maven Project  
2. **Language**: Java  
3. **Spring Boot Version**: 3.x 
4. **Dependencies** olarak şunları ekleyin:
   - Spring Web
   - Spring Data JPA
   - Spring Security
   - H2 Database
   - Lombok
   - Springdoc OpenAPI 
5. **Generate** butonuna tıklayın ve inen zip dosyasını açın.
6. IntelliJ IDEA ile projeyi açın.

---

## ⚙️ Çalışma Mantığı
1. Kullanıcı **kayıt** olur veya **giriş** yapar.
2. Başarılı girişte JWT token üretilir ve istemciye döndürülür.
3. İsteklerde Authorization header içinde token gönderilir.
4. Spring Security filtreleri token'ı doğrular ve kullanıcının yetkilerini belirler.
5. Kullanıcı rolüne göre istenen işlemler yapılır.

---

## 🚀 Projenin Çalıştırılması

1. **Projeyi IntelliJ IDEA ile açın.**
2. Terminalden proje klasörüne gidin:
   ```bash
   cd proje_klasoru_yolu
   ```
3. Spring Boot uygulamasını başlatın:
   ```bash
   mvn spring-boot:run
   ```
4. Uygulama çalıştıktan sonra şu adreslere gidin:
   - **Swagger UI**: [http://localhost:8080/swagger-ui/index.html#/company-controller/createCompany](http://localhost:8080/swagger-ui/index.html#/company-controller/createCompany)
   - **H2 Console**: [http://localhost:8080/h2-console/login.do](http://localhost:8080/h2-console/login.do)

---

## 📝 Git Commit Süreci Hakkında Not
> Projeyi IntelliJ IDEA’da yaptım. Projeyi bitirmek üzereyken yanlış bir açıklayıcı git commit yazdım.
>  Bunu silmek istediğimde “revert commit” seçeneğine tıkladım ve projedeki bütün kodlarım gitti. Neyse ki tam olmayan bir yedeğim vardı, onu kullandım ve eksik kısımları tekrar ekledim.
>  Bu yüzden şu anda tamamladığım açıklayıcı git commit’ler **güncel tarihlerdedir**.

---

## 📌 Özet
Bu proje, **Spring Boot** ekosisteminde **REST API geliştirme**, **JWT tabanlı güvenlik**, **rol bazlı yetkilendirme** ve **Swagger dokümantasyonu** konularında tam kapsamlı bir örnek sunmaktadır.  
Kurumsal yönetim sistemlerinde kullanılabilecek sağlam bir temel mimari sağlamaktadır.
