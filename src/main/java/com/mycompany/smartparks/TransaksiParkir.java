/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartparks;

public class TransaksiParkir {
    private int idTransaksi;
    private Kendaraan kendaraan;
    private int jamMasuk;
    private int jamKeluar;
    private int biaya;
    private Pembayaran pembayaran;
    private int totalBayar;
    private boolean selesai; // false = masih parkir, true = sudah bayar

    // Konstruktor untuk transaksi baru (saat kendaraan masuk)
    public TransaksiParkir(int idTransaksi, Kendaraan kendaraan, int jamMasuk) {
        this.idTransaksi = idTransaksi;
        this.kendaraan = kendaraan;
        this.jamMasuk = jamMasuk;
        this.selesai = false;
    }

    // Menghitung lama parkir (minimal 1 jam)
    public int hitungDurasi() {
        int durasi = jamKeluar - jamMasuk;
        if (durasi < 1) {
            durasi = 1;
        }
        return durasi;
    }

    // Menghitung biaya parkir sesuai jenis kendaraan
    // Motor : Rp2000 jam pertama + Rp1000 tiap jam berikutnya
    // Mobil : Rp5000 jam pertama + Rp3000 tiap jam berikutnya
    public int hitungBiaya() {
        int jamTambahan = hitungDurasi() - 1;
        if (kendaraan.getJenis().equals("Motor")) {
            return 2000 + jamTambahan * 1000;
        } else {
            return 5000 + jamTambahan * 3000;
        }
    }

    // Memproses pembayaran: hitung biaya dan total bayar
    public void prosesPembayaran(Pembayaran p) {
        pembayaran = p;
        biaya = hitungBiaya();
        totalBayar = p.hitungTotal(biaya);
        selesai = true;
    }

    // Mencetak struk parkir
    public void cetakStruk() {
        System.out.println("========== STRUK PARKIR ==========");
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("Plat Nomor   : " + kendaraan.getPlatNomor());
        System.out.println("Jenis        : " + kendaraan.getJenis());
        System.out.println("Jam Masuk    : " + jamMasuk + ":00");
        System.out.println("Jam Keluar   : " + jamKeluar + ":00");
        System.out.println("Durasi       : " + hitungDurasi() + " jam");
        System.out.println("Biaya Parkir : Rp" + biaya);
        System.out.println("Metode Bayar : " + pembayaran.getMetode());
        System.out.println("Potongan     : Rp" + pembayaran.hitungPotongan(biaya)
                + " (" + pembayaran.getPersenPotongan() + "%)");
        System.out.println("Total Bayar  : Rp" + totalBayar);
        System.out.println("==================================");
    }

    // Getter dan setter
    public int getIdTransaksi() {
        return idTransaksi;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public int getJamMasuk() {
        return jamMasuk;
    }

    public int getJamKeluar() {
        return jamKeluar;
    }

    public void setJamKeluar(int jamKeluar) {
        this.jamKeluar = jamKeluar;
    }

    public int getBiaya() {
        return biaya;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public int getTotalBayar() {
        return totalBayar;
    }

    public boolean isSelesai() {
        return selesai;
    }
}
