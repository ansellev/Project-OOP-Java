-- DESKRIPSI SINGKAT --

Aplikasi ini menerapkan konsep CRUD (Create, Read, Update/Search, Delete) dan prinsip Object-Oriented Programming (OOP) secara menyeluruh.
First Auto Factory adalah aplikasi manajemen showroom dan pabrik mobil berbasis Desktop (Java Swing).
Aplikasi ini dirancang untuk mensimulasikan proses produksi mobil, penyimpanan inventaris, pencarian, penjualan, hingga penyimpanan data ke dalam file eksternal dengan antarmuka Dark Mode yang modern.

-- FITUR -- 
1. Create Car: Memproduksi mobil baru dengan pilihan tipe (Sedan, SUV, Hatchback).
2. Show Car: Menampilkan seluruh stok mobil di gudang dalam bentuk tabel interaktif.
3. Search Car: Mencari mobil spesifik berdasarkan nama.
4. Sell Car: Menghapus data mobil (simulasi penjualan) berdasarkan VIN unik.
5. Save Data: Menyimpan seluruh data inventaris ke file teks (cars.txt) agar data tidak hilang.

-- CARA MENJALANKAN --

Prasyarat:
a. Pastikan komputer sudah terinstall Java Development Kit (JDK) minimal versi 8.

b. Disarankan menggunakan IDE seperti Eclipse, IntelliJ IDEA, atau VS Code.

Langkah-Langkah:
1. Clone atau Download proyek ini.
2. Buka folder proyek di IDE pilihanmu.
3. Cari file utama di lokasi: src/showroom/ui/MainMenu.java.
4. Klik Run pada file MainMenu.java.
Output File:
Setelah melakukan penyimpanan data (tombol Save), file cars.txt akan otomatis muncul di folder root proyek.

-- DAFTAR CLASS DAN FUNGSINYA --

1. Package showroom.models (Data Logic)
Car.java: Abstract Class induk yang mendefinisikan atribut dasar mobil (nama, hp, vin, kapasitas).
SUV.java, Sedan.java, Hatchback.java: Sub-class yang mewarisi Car dengan spesifikasi default masing-masing.

2. Package showroom.ui (Tampilan Utama)
MainMenu.java: Entry point aplikasi. Menampilkan dashboard utama berisi navigasi tombol menu.

3. Package showroom.ui.dialogs (Popup Jendela)
CreateCarDialog.java: Form input untuk membuat mobil baru dengan validasi dan custom toggle button.
ShowCarDialog.java: Menampilkan tabel daftar mobil yang ada di inventaris.
SearchCarDialog.java: Fitur pencarian mobil menggunakan Java Stream API (filter by name).
SellCarDialog.java: Menampilkan tabel untuk memilih dan menghapus mobil berdasarkan VIN.

4. Package showroom.ui.components (Desain Custom)
BackgroundPanel.java: Panel dengan algoritma Radial Gradient untuk background efek "Glow" tanpa gambar eksternal.
RoundedPanel.java: Panel transparan dengan sudut membulat untuk wadah menu utama.

5. Package showroom.utils (Utilitas)
AppTheme.java: Pusat konfigurasi warna (Palet Dark Mode, Cyan Accent) dan Font agar desain konsisten.
FileManager.java: Menangani operasi File I/O (menyimpan ArrayList ke file .txt).

-- PENJELASAN KONSEP OOP --
1. Encapsulation 
Seluruh atribut data pada class Car bersifat private untuk melindungi data dari akses langsung yang tidak sah. Data hanya dapat diakses atau diubah melalui method public (Getter).
Contohnya private String vin; diakses melalui public String getVin().

2. Inheritance 
Mencegah duplikasi kode dengan mewariskan sifat umum.
Implementasinya adalah pada Class SUV, Sedan, dan Hatchback menggunakan kata kunci extends Car. Mereka otomatis memiliki atribut nama, hp, dan vin tanpa perlu menuliskannya ulang.

3. Polymorphism 
Kemampuan objek untuk memiliki banyak bentuk.
Implementasinya adalah menggunakan koleksi ArrayList<Car>. List ini bertipe induk (Car), namun dapat menyimpan berbagai bentuk objek anak (new SUV(), new Sedan()).
Saat method c.getType() dipanggil, hasilnya akan berbeda tergantung objek aslinya.

4. Abstraction 
Menyembunyikan detail implementasi yang kompleks dan hanya menampilkan kerangka kerjanya.
Implementasinya adalah pada Class Car dideklarasikan sebagai public abstract class. Kita tidak bisa membuat objek new Car() secara langsung, melainkan harus membuat objek yang spesifik.
Ini memastikan setiap mobil di pabrik pasti memiliki tipe yang jelas.
