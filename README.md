# Kurumsal Web Uygulaması | Yazılım Mühendisliği Dersi(BMÜ-326) Dönem Projesi


Bu proje, kurumsal bir web uygulaması geliştirmek amacıyla oluşturulmuştur. Proje, Java ve Spring Boot kullanarak çeşitli kurumsal işlevleri yerine getiren bir web uygulaması geliştirmeyi hedeflemektedir. Projede kullanıcı yönetimi, e-posta gönderimi ve veri tabanı işlemleri gibi özellikler bulunmaktadır.


# Kullanılan Teknolojiler
- **Java**: Projenin ana programlama dili.
- **Spring Boot**: Projeyi hızlı bir şekilde ayağa kaldırmak için kullanılan framework çatısı.
- **Maven**: Proje yönetimi ve bağımlılık yönetimi için kullanılan araç.
- **JUnit**: Birim testleri yazmak için kullanılan test framework'ü.
- **Mockito**: Mock nesneleri oluşturmak için kullanılan test framework'ü.
- **MySQL**: Veri tabanı yönetim sistemi.
- **Lombok**: Boilerplate kod oluşturmak için.
- **Unirest**: HTTP istekleri yapmak için kullanılan kütüphane.
- **Circle CI/CD**: Sürekli Entegrasyon ve Sürekli Dağıtım için kullanılan tool.
- **HTML**: Web sayfalarının yapısını oluşturmak için kullanılan işaretleme dili.
- **CSS**: Web sayfalarının stil ve düzenini belirlemek için kullanılan stil dili.
- **JavaScript**: Web sayfalarına dinamik işlevsellik eklemek için kullanılan programlama dili.

# Backend

### `SecurityConfig` Sınıfı

`SecurityConfig` sınıfı, güvenlik yapılandırmalarını yönetir. Bu sınıf aşağıdaki işlevleri yerine getirir:

1. **Kimlik Doğrulama ve Yetkilendirme**: Kullanıcıların kimlik doğrulama ve yetkilendirme işlemlerini yapılandırır.
2. **HTTP Güvenlik Yapılandırmaları**: Hangi URL'lerin korunacağını ve hangi URL'lerin herkese açık olacağını belirler.
3. **Güvenlik Filtreleri**: Güvenlik filtre zincirini yapılandırır.
4. **Kullanıcı Detayları Hizmeti**: Kullanıcı bilgilerini yüklemek için bir `UserDetailsService` yapılandırır.
5. **Şifreleme**: Parola şifreleme ve çözme işlemlerini yapılandırır.

### `ContactController` Sınıfı

`ContactController` sınıfı, iletişim bilgileri ile ilgili HTTP isteklerini yöneten bir Spring MVC denetleyicisidir. Bu sınıf, CRUD işlemlerini gerçekleştiren çeşitli endpoint'ler sağlar:

- **GET /contacts**: Tüm iletişim bilgilerini listeler.
- **POST /contacts**: Yeni bir iletişim bilgisi ekler.
- **PUT /contacts/{id}**: Belirli bir iletişim bilgisini günceller.
- **DELETE /contacts/{id}**: Belirli bir iletişim bilgisini siler.

### `CustomErrorController` Sınıfı

`CustomErrorController` sınıfı, uygulama genelinde özel hata sayfalarını yönetmek için kullanılır. Bu sınıf, hata durumlarında kullanıcıya daha anlamlı mesajlar ve sayfalar sunar. Örneğin, 404 ve 500 hata kodları için özel sayfalar sağlar.

### `AdminModel` Sınıfı

`AdminModel` sınıfı, yönetici kullanıcıların verilerini temsil eden bir JPA varlık sınıfıdır. Bu sınıf, yöneticilerin kimlik bilgilerini ve diğer ilgili bilgileri içerir. Örneğin, kullanıcı adı, şifre ve roller gibi alanlar içerir.

### `ContactModel` Sınıfı

`ContactModel` sınıfı, iletişim bilgilerini temsil eden bir JPA varlık sınıfıdır. Bu sınıf, kullanıcıların ad, e-posta ve telefon numarası gibi bilgilerini içerir. Örneğin, `id`, `ad`, `email` ve `telefon` alanları bulunur.

### `AdminRepository` Arayüzü

`AdminRepository`, `AdminModel` sınıfı için JPA repository arayüzüdür. Bu arayüz, temel CRUD işlemlerini sağlar. Örneğin, `findByUsername` gibi özel sorgular içerebilir.

### `ContactRepository` Arayüzü

`ContactRepository`, `ContactModel` sınıfı için JPA repository arayüzüdür. Bu arayüz, temel CRUD işlemlerini sağlar. Örneğin, `findByEmail` gibi özel sorgular içerebilir.

### `AdminService` Sınıfı

`AdminService` sınıfı, yönetici kullanıcılarla ilgili iş mantığını içeren bir hizmet sınıfıdır. Bu sınıf, yöneticilerin kimlik doğrulama ve yetkilendirme işlemlerini yönetir. Örneğin, kullanıcı doğrulama ve yetki kontrolü işlemlerini içerir.

### `ContactService` Sınıfı

`ContactService` sınıfı, iletişim bilgileri ile ilgili iş mantığını içeren bir hizmet sınıfıdır. Bu sınıf, iletişim bilgilerini kaydetme, güncelleme, silme ve listeleme işlemlerini yönetir. Örneğin, `getAllContacts`, `saveContact` ve `deleteContactById` gibi metodlar içerir.

### `CustomUserService` Sınıfı

`CustomUserService` sınıfı, özel kullanıcı hizmetlerini yöneten bir sınıftır. Bu sınıf, kullanıcıların kimlik doğrulama ve yetkilendirme işlemlerini yönetir. Örneğin, kullanıcı kayıt ve giriş işlemlerini içerir.

### `CustomUserDetails` Sınıfı

`CustomUserDetails` sınıfı, Spring Security'nin kullanıcı detayları modelini özelleştiren bir sınıftır. Bu sınıf, kullanıcıların kimlik bilgilerini ve yetkilerini içerir. Örneğin, kullanıcı adı, şifre ve roller gibi alanlar içerir.

### `CustomUserDetailsService` Sınıfı

`CustomUserDetailsService` sınıfı, `UserDetailsService` arayüzünü uygulayan ve kullanıcı bilgilerini yükleyen bir hizmet sınıfıdır. Bu sınıf, kullanıcıların kimlik doğrulama işlemlerini yönetir. Örneğin, `loadUserByUsername` metodunu içerir.

### `EmailSenderService` Sınıfı

`EmailSenderService` sınıfı, e-posta gönderme işlemlerini yöneten bir hizmet sınıfıdır. Bu sınıf, uygulama içinde e-posta gönderme işlevselliğini sağlar. Örneğin, `sendEmail` metodunu içerir.

## Testler

Testler, JUnit 5 ve Mockito kullanılarak yazılmıştır. Test sınıfları `src/test/java` dizininde bulunur.
- `ContactServiceTest` sınıfı, `ContactService` sınıfının birim testlerini gerçekleştirmek için kullanılır. Bu sınıf, `ContactService` sınıfının çeşitli metodlarını test eder ve bu metodların doğru çalışıp çalışmadığını doğrular.

# Sürekli Entegrasyon ve Dağıtım

Bu proje, sürekli entegrasyon ve dağıtım için CircleCI kullanmaktadır. CircleCI yapılandırması `.circleci/config.yml` dosyasında tanımlanmıştır.

### Temel Özellikler

- **Test**: `test-java` işi, OpenJDK ve MySQL ile bir Docker ortamı kurar, MySQL konteynırının hazır olmasını bekler ve ardından Maven komutlarını çalıştırarak projeyi doğrular ve test eder.
- **Önbellekleme**: Yapılandırma, Maven bağımlılıklarını önbelleğe almak için adımlar içerir, bu da derleme sürecini hızlandırır.
- **Dağıtım**: `deploy` işi, SSH ortamını hazırlar, GitHub'ı bilinen hostlara ekler ve değişiklikleri GitHub'daki `dummy-master` dalına iter.

### Yapılandırma Detayları

- **Docker İmajları**: Java için `cimg/openjdk:21.0` ve MySQL için `cimg/mysql:8.0` kullanır.
- **Ortam Değişkenleri**: `MYSQL_ROOT_PASSWORD`, `MYSQL_DATABASE`, `MYSQL_USER` ve `MYSQL_PASSWORD` gibi MySQL ortam değişkenlerini ayarlar.
- **Önbellekleme**: Maven bağımlılıklarını önbelleğe almak için `pom.xml` ve diğer yapı dosyalarına dayalı bir önbellek anahtarı hesaplar.
- **Test Sonuçları**: Test sonuçlarını `target/surefire-reports` dizininde saklar.
- **SSH Anahtarları**: Dağıtım için SSH anahtarlarını ekler ve GitHub'ı bilinen bir host olarak yapılandırır.

Daha fazla detay için, proje deposundaki `.circleci/config.yml` dosyasına bakabilirsiniz.

# Frontend

Frontend kısmı, kullanıcı arayüzünü oluşturmak için HTML, CSS ve JavaScript kullanır.

