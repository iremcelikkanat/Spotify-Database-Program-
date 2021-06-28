Programlama Laboratuvarı 
Spotify Veritabanı Yönetim Sistemi


Özet—Bu çalışmada arayüz bileşenleriyle birlikte bir veritabanı yönetim sistemi oluşturularak, Spotify klonu gerçekleştirilmiştir. Bu uygulamayı geliştirirken Java programlama dili, Swing arayüzü ve Mysql  veritabanı kullanılmıştır. 
Anahtar kelimeler— Veritabanı, VeriTabanı,Nesne, Birebir , Arayüz, Spotify, Uygulaması 
I.	GIRIŞ 

Gerçekleştirilen proje temel olarak bir veritabanı yönetim sistemidir. Uygulama kullanıcı ve admin tarafından etkileşime girilebilen birtakım arayüz bileşenlerine sahipti. Bu bağlantılar sonucu ilgili veritabanı üzerinde çok çeşitli işlemler gerçekleştiriliyor, bazen kullanıcıdan secımler yapması ısteniyor, bazen ise kullanıcıya veriler iletiliyordu. Spotify içerisinde çeşitli müzik listeleri bulunan ve bunları kullanıcılara sunan bir müzik  platformu, proje kapsamında sorumlu olduğumuz kısımlar; Her şarkı için dinlenme sayısı tutulması Müzik türlerine göre ( pop, jazz, klasik) oluşturulmuş en çok dinlenen 10 şarkı listesi, genel olarak en çok dinlenen 10 şarkının listesi , ülkelere göre en çok dinlenen 10 şarkı listesi kullanıcıya sunulmasıdır.Böyle 

İrem Çelikkanat
Kocaeli Üniversitesi Mühendislik Fakültesi Bilgisayar Mühendisliği 190202124@kocaeli.edu.tr

bir programın çalışması için bazı temel koşullar bulunmaktaydı. Bunları sırası ile gerçekleştirmeye başlamadan önce ilk olarak kullanıcının program içerisinde izleyebileceği bir yol haritası çıkardık. Bu şekilde kullanıcının etkileşime ilk başladığı andan programı sonlandırdığı ana kadar ki sürdürdüğü tüm hareketliliği takip edebilecek ve program akışımızı da buna göre yönlendirebilecektik. Kullanıcı programı çalıştırdığında kendisini giriş sayfası karşılayacak. İsteğe bağlı olarak kayıt olma ya da sisteme giriş işlemlerini gerçekleştirebilecek veya admin ise admin girişi yapabilecek .Birbirini tetikleyen art arda başka seçenekler ile işlemlerini sürdürebilecekti. Bu akış şemasını referans alarak taslak bir arayüz hazırlama fikrinin projenin gidişatını oldukça rahatlatacağını düşünerek arayüzlerin basit ön tasarımlarını gerçekleştirdik. Daha önceden de bahsettiğimiz bu akışları hayali olarak bu arayüzler üzerine yerleştirmeye başladık. Arayüzlerin plana dahil olmasıyla birlikte kullanıcı etkileşimi de başlamış oldu. Bu etkileşim sonucunda veriler ile gerçekleştireceğimiz işlemleri de önceden planlamamız gerekmekteydi. Bu yüzden sistemimizde kullanacağımız veritabanı modelini bize verilen kılavuza da bağlı kalarak oluşturmaya başladık. Öncelikle bir Mysql workbench programında veritabanını tasarladık ve ardından eksik kısımları oluşturduk. Veritabanı modelimiz tamamen hazır olduğunda akış üzerinden etkileşimleri tek tek tespit edip veritabanına veri girdisi yapan ya da çeşitli verileri elde etmemizi sağlayan sorguları oluşturmaya başladık. Bu aşamadan sonra taslak olarak projemizin çok büyük bir kısmı zaten oluşmuştu. Daha sonrasında uygun teknik şartları oluşturup gerçekleştirmek kalmıştı. Projemiz için gerekli çalışma ortamlarını hazırlayıp, hazırladığımız tüm bu planlar çerçevesinde geliştirme işlemine başladık. 
II.	YÖNTEMLER VE PROGRAM MIMARISI 


Bu kısımda programın farklı özelliklerini oluşturmak için kullandığımız araçlar ve yöntemler üzerinde durularak ayrıntılı olarak bilgi verilecektir ve program mimarisi daha detaylı bir şekilde açıklanacaktır.

A.	Veritabanı

 Giriş bölümünde bahsettiğimiz gibi dizayn aşamasından sonra veritabanını oluşturmaya başladık. Mysql veritabanını kullanmaya karar verdik. Bu yüzden ilk şemamızı burada oluşturduk. Daha sonra ilgili tabloları ekledik. Burada bizim doldurmamız istenen bazı kısımlar da vardı. Programımızda on iki adet tablo bulunmaktaydı. Bunlar admin, album, alum_sarki, calma_listesi,kullanici, listedekisarkilar,kullanicitakipcalmalistesi,muzikturu,sanatci,sarki,takipedilenkullanici ve ulke tablolarıydı. Verilen pdfteki ilgili alanları uygun veri türleri ile tablolar içerisinde oluşturduk. Çoka çok ilişkiye sahip sarki ve album tablosu  mevcuttu. Bunların aralarında da bir ilişki tablosu oluşturulmalıydı. Burada çoka çok ilişki olmasının sebebi ise bir programın birden fazla türü olabilmesi aynı zamanda bir türün de birçok programa ait olabilmesiydi. Bunları belirledikten sonra tablolarımızın temel anahtar değerlerini ayarladık. “sarki” tablosunda “sarki_id” alanını eşsiz ve birincil anahtar yaptık çünkü sistemdeki her sarkı tek bir kere kayıt olmalıydı. Aynı şekilde album tablosundaki “albumID” alanı da o tablo için eşsiz ve birincil anahtar olacaktı. Çünkü aynı isimli bir album tablo içerisinde mevcut olmamalıydı. “ulke” tablosu altında “ulkeID” alani da aynı şekilde eşsiz ve birincil anahtar olmaktaydı. Bu sebeple bize verilen alanlar haricinde “kullaniciID” ve “muzikturuID” alanlarını da tabloya birincil anahtar olarak ekledik. İkisinin bir birincil anahtar olmasının sebebi kullanıcının dinlediği bir sarkının iki kere kaydedilmemesinin gerekmesiydi.
Tüm bunların sonunda elimizde tabloları tamamen oluşturulmuş bir şema oldu. 

B.	Veri Yapıları

 Özel Sınıflar ve Sistemler Proje boyunca çeşitli veri yapılarını kullanarak işlemler gerçekleştirdik. Bazı noktalarda kendi özel sınıflarımızı yazarak ara yüz elemanlarını kendimize göre düzenledik, yeniden oluşturduk. Bazı noktalar da ise programımız için faydalı sistemler oluşturduk. Bu kısımda bu yapılara değineceğiz. Programımızda sarkı tablosu statik olarak kayitEkle sınıfı altında tanımlı bir şekilde bulunmakta ve buradan yönetilmektedir. Bu şekilde pencereler arasındaki iletişim kolay bir şekilde sağlanmaktadır. Aynı şekilde tüm veritabanı yapıları kendi özel veritabanı sınıfı içerisinde tanımlıdır ve gerekli sorgu işlemlerinde statik tanımlı bu yapılar çağrılarak kullanılmaktadır. Bu da her sınıfta tekrar tekrar veritabanı elemanlarını yeniden tanımlama gereksinimini ortadan kaldırarak işimizi oldukça kolaylaştırmaktadır. kullaniciGiris ve hesap sınıfları özel olarak yaratılmış sınıflardır ve kendi arayüz bileşenlerimizdir. Burada çeşitli swing bileşenleri yeniden düzenlenerek oluşturulmuşlardır. Herhangi bir arama türünde işlem gerçekleştirdiğinizde sorgudan dönen sarkiidler bir ArrayList içerisinde dönmekte ve bu liste üzerinde ilgili panele ekleme,silme ve guncelleme işlemleri yapılmaktadır. güncelleme işlemlerini gerçek zamanlı gerçekleşmesi için aramanın yapılacağı textbox üzerinde değişiklik tespiti yapılmış. Her güncellemede listele butonu ile dinamik arama sistemi oluşturulmuştur

C.	GELIŞTIRME ORTAMI VE KULLANILAN DIL 
Projeyi Java Programlama dilinde JDK 8 ile Windows işletim sistemi üzerinde gerçekleştirirken, Eclipse geliştirme ortamı olarak kullandık. Son proje dosya yapısı eclipse dosya formatındadır . İçerisinde harici kütüphane ve dosya bağımlılıklarına sahip çalıştırılabilir jar dosyası ve exe bulunmaktadır.

III.	PROGRAMIN GENEL YAPISI VE TASARIMI 
Program temel olarak çeşitli form pencerelerinden oluşuyor admin ve kullanıcı bu ekranlar üzerinden seçtiği çeşitli işlemleri gerçekleştiriyor. Bu işlemler arasında giriş yapma, üye olma, müzik listesi aratma, listeye müzik ekleme,ülkelere göre sıralama top10 listeleme ,kullanıcı takip etme vs. gibi özellikler bulunuyor.

 ![1](https://user-images.githubusercontent.com/56557278/123640029-6e41d900-d829-11eb-8571-98853f351ef7.jpg)

          Şekil 1 Kullanıcı,Admin  Giris ve Uye ol
          
 ![2](https://user-images.githubusercontent.com/56557278/123640072-7a2d9b00-d829-11eb-9fed-5ab0f9d6cec1.jpg)
                           Şekil 2 Admin sayfası
 ![3](https://user-images.githubusercontent.com/56557278/123640107-8154a900-d829-11eb-9c76-c4de3cefe7ec.jpg)
                       Şekil 3 Kullanıcı Ana Sayfa
 ![4](https://user-images.githubusercontent.com/56557278/123640138-8a457a80-d829-11eb-8361-60e03dfddd4a.jpg)
                        Şekil 4 Aranan kullanıcı profili

IV.	PROGRAMIN ÇALIŞTIRILMASI VE KULLANILMASI 
Çalıştırma işlemini düzgün kurulmuş bir java ile tıkla-çalıştır şeklinde gerçekleştiriniz ya da “program ile aynı dizinde” komut satırı ile çalıştırınız. Proje üzerinden derleme yapılmak istenirse Projenin dosya yapısı Eclipse projesi formatındadır. Proje klasörünü Eclipse ortamında kolaylıkla açabilirsiniz. Projeyi tüm ayarları yapılı bir şekilde derleyebilirsiniz. Program içerisinde tüm işlemler arayüz elemanları üzerinde detaylı olarak yazmaktadır. Program akışını yöneterek istediğiniz işlemleri gerçekleştiriniz. Görseller ile adım adım çalışma aşamaları ekte mevcuttur

V.	DENEYSEL SONUÇLAR 
Projeyi gerçekleştirmeden önce teorik olarak veritabanı tasarımını ve dizaynını gerçekleştirdik. Bu noktada Veritabanı yönetim sistemleri dersinde gördüğümüz ilişkisel cebir üzerinde pratik yapma imkanı bulduk. İlk defa ilişkisel cebri uygulamalı olarak kullandık. İlk defa veritabanı dizayn programlarını kullanarak elde ettiğimiz sonuçları referans aldık. Bir programı baştan aşağıya adım adım tasarlayarak tasarım deneyimimizi geliştirdik. Arayüzü gerçekleştirirken ilk defa bir projede form editörlerini kullandık bu noktada farklı layout sistemleri üzerinde deneyimler gerçekleştirme fırsatı bulduk. Form editörlerinin farklı layout sistemlerini deneyerek birbirleri arasında karşılaştırıp ihtiyacımıza göre kullandık.
VIII.SONUÇ 
Projeyi hazırlarken veritaban tablolarının oluşturulması ve uygulanması konusunda önemli bilgiler edindik. Ayrıca arayüz üzerinde çeşitli işlemler gerçekleştirerek kullanıcıya yönelik bir programın oluşma aşamalarını net olarak gözlemledik. 
VI.	KAYNAKÇA
https://www.youtube.com/channel/UC-EYPnTYleFrIPT9bpMCbQQ
https://www.youtube.com/watch?v=xJsbDa1tG5s
https://www.udemy.com/course/sifirdan-ileri-seviyeye-komple-java-gelistirici-kursu/learn/lecture/8523070#overview
KABA KOD
•	BASLA
•	textfielda girilen ad,sifre,mail,odeme bilgilerini değişkene ata.
•	kullanici tablosundan textfielde değişkenlerini kullanici_adi,email,sifre,ulkeID,odendi bilgilerine insert et.
•	Uyeliği tamamla.
•	Kullanıcı girişi yapmak için kullanici tablosundan isim ve sifre bilgilerini select et.
•	Eğer girilen bilgiler kullanıcı tablosundakı isim ve sifre ile eslesiyor ise kullaniciGiris sayfasını ac.
•	Admin girişi yapmak için admin tablosundan isim ve sifre bilgilerini select et.
•	Eğer girilen bilgiler admin tablosundakı isim ve sifre ile eslesiyor ise kayit ekleme sayfasını ac.
•	kayitEkleme sayfasında listele butonu ile sarki tablosu baglantısını yap.
•	sarki_id,sarki_adi,turID,sanatcialbum_id,suredinlenme,Sayisitarih sutunlarını tabloya getir.
•	Kaydet butonu için textfielda girilen id,ad,tarih,sanatci,album,tur,sure,dinlenmeSayisi,album id bilgilerini değişkenlere ata.
•	Textfielddaki değişkenleri Album tablosuna insert komutu ile ekle.
•	Textfielddaki değişkenler sarki tablosuna insert komutu ile ekle.
•	Güncelle butonu için textfielda girilen id,ad,tarih,sanatci,album,tur,sure,dinlenmeSayisi,album id bilgilerini değişkenlere ata.
•	Textfielddaki değişkenleri Album tablosuna update komutu ile ekle.
•	Textfielddaki değişkenler sarki tablosuna update komutu ile ekle.
•	KullaniciGiris sayfasına git.
•	giris sayfasından giris yapan kullanıcın idsini id değişkenıne ata.
•	listedekisarkilar tablosundan giris yapan kısının id'si ile eşlesen pop türündeki sarkı adları ve dinlenme sayılarını table pop tablosuna ekle. 
•	listedekisarkilar tablosundan giris yapan kısının id'si ile eşlesen caz türündeki sarkı adları ve dinlenme sayılarını table caz tablosuna ekle. 
•	listedekisarkilar tablosundan giris yapan kısının id'si ile eşlesen klasik türündeki sarkı adları ve dinlenme sayılarını table klasik tablosuna ekle. 
•	Comboboxtan pop,caz,klasik veya top10 seçeneklerinden birini seç.
•	Comboboxtantan yapılan seçim Pop ise pop müzikleri scrollPane üzerinden tabloda listele.
•	Comboboxtantan yapılan seçim Caz ise Caz müzikleri scrollPane üzerinden tabloda listele.
•	Comboboxtantan yapılan seçim Klasik ise Klasik müzikleri scrollPane üzerinden tabloda listele.
•	Comboboxtantan yapılan seçim top10 ise top10 müzikleri scrollPane üzerinden tabloda listele.
•	Listenen sarkılardan seçilen muzik turu Pop ise kulanıcının Pop Listesine ekle.
•	Eğer seçilen sarkı kullanıcının tablosunda mevcut ise Hata mesajı ver.
•	Listenen sarkılardan seçilen muzik turu Caz ise kulanıcının Caz Listesine ekle.
•	Eğer seçilen sarkı kullanıcının tablosunda mevcut ise Hata mesajı ver.
•	Listenen sarkılardan seçilen muzik turu Klasik ise kulanıcının Klasik Listesine ekle.
•	Eğer seçilen sarkı kullanıcının tablosunda mevcut ise Hata mesajı ver.
•	comboBox_1 den Ülke seçimi yap.
•	Seçilen ülke Türkiye ise Türkiye'de en çok dinlenen sarkıları listele.
•	Seçilen ülke İngiltere ise İngiltere 'de en çok dinlenen sarkıları listele.
•	Seçilen ülke Almanya ise Almanya'da en çok dinlenen sarkıları listele.
•	TextArama textfieldına aramak istenilen kullanıcı adını gir.
•	table2de TextArama textfieldına girilen kullanıcı adına benzer tüm isimleri listele.
•	table2 mouseClik özelliği ile seçilen kullanıcının hesap formu üzerinden Sayfasını aç.
•	Eger kullanici premium ise takip et butonunu aktif et.
•	Takip edilen kullanıcıyı kayitEkleme  sayfasında table adlı tabloya ekle.
•	Eger kullanici premium değil ise takip et butonunu pasif et.
•	ComboBox üzerinden pop,caz,klasik müzik türlerinden birini seç.
•	Eğer seçilen tur Pop ise Aranılan kullanıcının tum pop listesini giris yapan kullanıcının kullanici dinlenen sarkılar listesine ekle.
•	Eğer seçilen tur Caz ise Aranılan kullanıcının tum Caz listesini giris yapan kullanıcının kullanici dinlenen sarkılar listesine ekle.
•	Eğer seçilen tur Klasik ise Aranılan kullanıcının tum Klasik listesini giris yapan kullanıcının listedekisarkilar listesine ekle.
•	Aranılan kullanıcının ScrollPane üzerindeki table adlı Pop tablosundan seçilen sarkıyı kullanıcının kullanici dinlenen sarkılar listesine ekle.
•	Eğer eklenmek istenen sarkı listedekisarkilar tablosunda mevcut ise hata ver.
•	Aranılan kullanıcının ScrollPane üzerindeki table_1 adlı Caz  tablosundan seçilen sarkıyı kullanıcının listedekisarkilar listesine ekle.
•	Eğer eklenmek istenen sarkı listedekisarkilar tablosunda mevcut ise hata ver.
•	Aranılan kullanıcının ScrollPane üzerindeki table_2 adlı Klasik tablosundan seçilen sarkıyı kullanıcının listedekisarkilar listesine ekle.
•	Eğer eklenmek istenen sarkı listedekisarkilar tablosunda mevcut ise hata ver.
•	BİTİR
















                            ER DİYAGRAMI

![uml](https://user-images.githubusercontent.com/56557278/123640293-b06b1a80-d829-11eb-882d-1fe1d0c97839.jpg)


 
  
