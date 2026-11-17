/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartparks;
public class PengelolaParkir {

    // Array of objects: menyimpan banyak objek TransaksiParkir
    private TransaksiParkir[] daftarTransaksi;
    private int jumlahTransaksi;

    // Konstruktor: menyiapkan array berukuran 100
    public PengelolaParkir() {
        daftarTransaksi = new TransaksiParkir[100];
        jumlahTransaksi = 0;
    }

    // Mencatat kendaraan masuk
    public void kendaraanMasuk(Kendaraan k, int jamMasuk) {
        if (cariTransaksiAktif(k.getPlatNomor()) != null) {
            System.out.println("Gagal: kendaraan dengan plat ini masih parkir.");
        } else if (jumlahTransaksi >= 100) {
            System.out.println("Gagal: data transaksi sudah penuh.");
        } else {
            TransaksiParkir t = new TransaksiParkir(jumlahTransaksi + 1, k, jamMasuk);
            daftarTransaksi[jumlahTransaksi] = t;
            jumlahTransaksi++;
            System.out.println("Berhasil: " + k.getPlatNomor() + " masuk jam " + jamMasuk + ":00");
        }
    }

    // Memproses kendaraan keluar, pembayaran, dan cetak struk
    public void kendaraanKeluar(String plat, int jamKeluar, Pembayaran p) {
        TransaksiParkir t = cariTransaksiAktif(plat);
        if (t == null) {
            System.out.println("Gagal: plat nomor tidak ditemukan.");
        } else if (jamKeluar < t.getJamMasuk()) {
            System.out.println("Gagal: jam keluar lebih kecil dari jam masuk.");
        } else {
            t.setJamKeluar(jamKeluar);
            t.prosesPembayaran(p);
            t.cetakStruk();
        }
    }

    // Mencari transaksi yang masih parkir berdasarkan plat nomor
    // Hasilnya null jika tidak ditemukan
    public TransaksiParkir cariTransaksiAktif(String plat) {
        for (int i = 0; i < jumlahTransaksi; i++) {
            TransaksiParkir t = daftarTransaksi[i];
            if (!t.isSelesai() && t.getKendaraan().getPlatNomor().equals(plat)) {
                return t;
            }
        }
        return null;
    }

    // Menjumlahkan total bayar dari semua transaksi yang sudah selesai
    public int hitungPendapatan() {
        int total = 0;
        for (int i = 0; i < jumlahTransaksi; i++) {
            if (daftarTransaksi[i].isSelesai()) {
                total = total + daftarTransaksi[i].getTotalBayar();
            }
        }
        return total;
    }

    // Menampilkan kendaraan yang sedang parkir
    public void tampilkanDaftar() {
        int nomor = 0;
        System.out.println("--- Kendaraan Sedang Parkir ---");
        for (int i = 0; i < jumlahTransaksi; i++) {
            TransaksiParkir t = daftarTransaksi[i];
            if (!t.isSelesai()) {
                nomor++;
                System.out.println(nomor + ". " + t.getKendaraan().getPlatNomor()
                        + " (" + t.getKendaraan().getJenis() + ") - masuk jam "
                        + t.getJamMasuk() + ":00");
            }
        }
        if (nomor == 0) {
            System.out.println("Tidak ada kendaraan yang sedang parkir.");
        }
    }
}
