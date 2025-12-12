# FP_ASD_Traffic_Light_Simulation_FINAL

Proyek ini adalah **Simulasi Lalu Lintas Berbasis CLI (Command Line Interface)** yang dirancang untuk memodelkan jaringan jalan raya menggunakan struktur data **Graph**. Program ini menghitung rute tercepat antar persimpangan dan menganalisis tingkat kemacetan menggunakan algoritma pengurutan.

## 👥 Anggota Kelompok 3
* **Wikandika Setya Nugroho** (5026241033)
* **I Gusti Made Sedana Yoga** (5026241037)
* **Kaka Agastya Herlambang Wahyudi** (5026241115)
* **Akhtar Ibrahim** (5026241147)

---

## 🚀 Fitur & Algoritma Utama
Proyek ini mengimplementasikan konsep Algoritma dan Struktur Data (ASD) sebagai berikut:

### 1. Weighted Directed Graph
* **Implementasi:** `src/graph/Graph.java`
* **Fungsi:** Memodelkan persimpangan sebagai *Node* dan jalan raya sebagai *Edge* berarah. Setiap jalan memiliki bobot berupa durasi tempuh (berdasarkan jumlah kendaraan).

### 2. Dijkstra's Algorithm (Shortest Path)
* **Implementasi:** `src/graph/Graph.java`
* **Fungsi:** Menghitung rute tercepat dan paling efisien dari titik keberangkatan (*Source*) ke tujuan (*Destination*). Menggunakan `PriorityQueue` untuk efisiensi pencarian.

### 3. Merge Sort (Descending)
* **Implementasi:** `src/simulation/MergeSort.java`
* **Fungsi:** Mengurutkan data jalan berdasarkan **jumlah kendaraan** dan **durasi lampu** dari yang terbesar ke terkecil. Digunakan untuk menampilkan laporan statistik jalan termacet.

### 4. Visualisasi ASCII
* **Implementasi:** `src/simulation/AsciiGraphRenderer.java`
* **Fungsi:** Menampilkan representasi graf dan tabel data statistik secara visual di terminal agar mudah dibaca oleh pengguna.

---

## 🛠️ Prasyarat & Cara Menjalankan

### Prasyarat
* **Java Development Kit (JDK):** Versi 23 atau yang lebih baru disarankan (sesuai konfigurasi project).

### Cara Compile & Run
1.  Buka terminal atau CMD di direktori root proyek ini.
2.  Compile semua file Java:
    ```bash
    javac -d bin src/*.java src/graph/*.java src/simulation/*.java
    ```
3.  Jalankan program utama:
    ```bash
    java -cp bin Main
    ```

---

## 📂 Struktur Folder