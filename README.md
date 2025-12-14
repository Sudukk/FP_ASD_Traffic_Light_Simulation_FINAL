# Traffic Light Simulation (Final Project ASD)

> **Simulasi Lalu Lintas Adaptif Berbasis CLI Menggunakan Pendekatan Graph**

![Traffic Light Banner](https://img.shields.io/badge/Traffic-Simulation-red) ![Java](https://img.shields.io/badge/Language-Java-blue) ![Course](https://img.shields.io/badge/Course-Algoritma%20%26%20Struktur%20Data-green)

## 🏫 Identitas Proyek
**Mata Kuliah:** Algoritma & Struktur Data (ASD)  
**Kelas:** Sistem Informasi  
**Kelompok:** 3  
**Dosen Pengampu:** Renny Pradina Kusumawardani, S.T., M.T.

### 👥 Anggota Kelompok
| No | Nama Anggota | NRP |
|:--:|:---|:---|
| 1 | **Wikandika Setya Nugroho** | 5026241033 |
| 2 | **I Gusti Made Sedana Yoga** | 5026241037 |
| 3 | **Kaka Agastya Herlambang Wahyudi** | 5026241115 |
| 4 | **Akhtar Ibrahim** | 5026241147 |

---

## 📖 Isi Laporan

### 1. Latar Belakang Masalah
Kemacetan di persimpangan kota besar seperti Surabaya sering kali disebabkan oleh sistem lampu lalu lintas konvensional yang bersifat statis (*Fixed Time*). Sistem ini tidak adaptif terhadap volume kendaraan yang berubah-ubah secara *real-time*.

Berdasarkan data:
* Lampu lalu lintas yang tidak adaptif menyumbang **69%** penyebab kemacetan.
* Memiliki korelasi yang sangat kuat (**0,829**) terhadap penumpukan kendaraan di jalan raya.

Oleh karena itu, diperlukan sebuah simulasi sistem yang dapat menentukan durasi lampu lalu lintas berdasarkan kepadatan kendaraan dan mencari rute tercepat bagi pengendara.

### 2. Solusi yang Ditawarkan
Kami mengembangkan **Traffic Light Simulator**, sebuah aplikasi berbasis *Command Line Interface* (CLI) yang memodelkan jaringan jalan raya sebagai **Weighted Directed Graph**.

Sistem ini menawarkan solusi:
* **Adaptive Timing:** Durasi hambatan (bobot jalan) dihitung secara dinamis berdasarkan jumlah kendaraan.
* **Shortest Path Finding:** Membantu pengendara menemukan rute tercepat dari satu titik ke titik lain dengan mempertimbangkan kepadatan lalu lintas.
* **Traffic Analysis:** Memberikan laporan statistik jalan mana yang paling padat dan membutuhkan prioritas penanganan.

### 3. Fitur Utama
* **Manajemen Node & Edge Dinamis:** Input manual nama persimpangan dan koneksi jalan dengan validasi data.
* **Visualisasi Graph ASCII:** Menampilkan peta koneksi antar jalan dalam format teks yang mudah dibaca.
* **Pencarian Rute Tercepat:** Menghitung jalur paling efisien dari *Start* ke *Destination*.
* **Laporan Efektivitas:** Menghitung persentase efisiensi rute dibandingkan rata-rata normal.
* **Sorting Kepadatan:** Menampilkan tabel jalan yang diurutkan dari yang paling macet.

---

## 🧠 Algoritma & Implementasi

Proyek ini menerapkan beberapa konsep utama Struktur Data dan Algoritma untuk menunjang fiturnya:

### 1. Weighted Directed Graph
* **Deskripsi:** Memodelkan peta lalu lintas di mana persimpangan adalah *Node* dan jalan adalah *Edge* berarah dengan bobot.
* **Lokasi File:** `src/graph/Graph.java`
* **Implementasi:** Menggunakan `List<List<Edge>> adj` (Adjacency List).

### 2. Dijkstra’s Algorithm (Shortest Path)
* **Deskripsi:** Mencari rute terpendek dengan total durasi tempuh paling minim antar dua persimpangan.
* **Lokasi File:** `src/graph/Graph.java` (Method `dijkstra`)
* **Implementasi:** Menggunakan `PriorityQueue` untuk eksplorasi node paling efisien.

### 3. Merge Sort (Descending)
* **Deskripsi:** Mengurutkan data jalan berdasarkan jumlah kendaraan/durasi dari terbesar ke terkecil untuk analisis statistik.
* **Lokasi File:** `src/simulation/MergeSort.java`
* **Implementasi:** Algoritma *Divide and Conquer* dengan kompleksitas waktu **O(n log n)**.

### 4. Visualisasi & Mapping
* **Deskripsi:** Memetakan nama persimpangan ke indeks dan merender graf ke layar.
* **Lokasi File:** `src/simulation/NodeNameManager.java` & `src/simulation/AsciiGraphRenderer.java`

---

## 📸 Screenshot Program

**1. Input Data**
![Data Input](https://drive.google.com/uc?export=view&id=1XMthLvX0ZVQjO5reCRROpjT-104auuRE)

**2. Tabel Kepadatan (Sorted)**
![Sorted Table](https://drive.google.com/uc?export=view&id=1s0BTyKekuHPGNyXQ_epyIM2oKwfLEKj-)

**3. Hasil Rute Tercepat**
![Shortest Path](https://drive.google.com/uc?export=view&id=1-9b_S0Uil8CYsUvF_4UoeXZK66d0jMk5)

---

## 📸 Video Link
**[Video Link](https://youtu.be/X4x61kZJHm4)**

---

## 📝 Riwayat Pembaruan (Update Log)

**Update: 14 Desember 2025 (00:14)**
* **Deskripsi Update:** Dilakukan penyederhanaan dan perbaikan pada logika input pengguna. Sistem diperbarui agar pengguna cukup memasukkan input berupa **Source** (Lokasi Keberangkatan) dan **Destination** (Tujuan Akhir) saja untuk menjalankan simulasi pencarian rute tercepat.
* **File Terdampak:**
    * `src/Main.java`
    * `src/simulation/AsciiGraphRenderer.java`

---

## 🔗 Daftar Proyek Akhir Lainnya

Berikut adalah referensi proyek akhir dari kelompok lain di kelas Sistem Informasi:

1.  **Kelompok 1 - [Judul Proyek]**: [Link Repository]
2.  **Kelompok 2 - [Judul Proyek]**: [Link Repository]
3.  **Kelompok 4 - [Judul Proyek]**: [Link Repository]
4.  **Kelompok 5 - [Judul Proyek]**: [Link Repository]
5.  **Kelompok 6 - [Judul Proyek]**: [Link Repository]

---
**Teknologi:** Java JDK 23, IntelliJ IDEA  
© 2024 Kelompok 3 - Sistem Informasi ITS