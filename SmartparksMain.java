/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.smartparks;
import java.util.Scanner;

public class SmartparksMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Instansiasi objek PengelolaParkir
        PengelolaParkir pengelola = new PengelolaParkir();

        int pilihan = -1;
        while (pilihan != 0) {
            System.out.println();
            System.out.println("===== SMARTPARK =====");
            System.out.println("1. Kendaraan masuk");
            System.out.println("2. Kendaraan keluar");
            System.out.println("3. Daftar kendaraan sedang parkir");
            System.out.println("4. Total pendapatan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Plat nomor: ");
                    String platMasuk = input.nextLine();
                    System.out.print("Jenis kendaraan (1. Motor, 2. Mobil): ");
                    int pilihJenis = input.nextInt();
                    input.nextLine();
                    System.out.print("Jam masuk (0-23): ");
                    int jamMasuk = input.nextInt();
                    input.nextLine();

                    if (pilihJenis != 1 && pilihJenis != 2) {
                        System.out.println("Gagal: jenis kendaraan tidak valid.");
                    } else if (jamMasuk < 0 || jamMasuk > 23) {
                        System.out.println("Gagal: jam harus 0-23.");
                    } else {
                        String jenis = "Mobil";
                        if (pilihJenis == 1) {
                            jenis = "Motor";
                        }
                        // Instansiasi objek Kendaraan
                        Kendaraan k = new Kendaraan(platMasuk, jenis);
                        pengelola.kendaraanMasuk(k, jamMasuk);
                    }
                    break;

                case 2:
                    System.out.print("Plat nomor: ");
                    String platKeluar = input.nextLine();
                    System.out.print("Jam keluar (0-23): ");
                    int jamKeluar = input.nextInt();
                    input.nextLine();
                    System.out.print("Metode bayar (1. Tunai, 2. Non-Tunai, 3. QRIS): ");
                    int pilihBayar = input.nextInt();
                    input.nextLine();

                    if (pilihBayar < 1 || pilihBayar > 3) {
                        System.out.println("Gagal: metode bayar tidak valid.");
                    } else if (jamKeluar < 0 || jamKeluar > 23) {
                        System.out.println("Gagal: jam harus 0-23.");
                    } else {
                        String metode = "QRIS";
                        if (pilihBayar == 1) {
                            metode = "Tunai";
                        } else if (pilihBayar == 2) {
                            metode = "Non-Tunai";
                        }
                        // Instansiasi objek Pembayaran
                        Pembayaran p = new Pembayaran(metode);
                        pengelola.kendaraanKeluar(platKeluar, jamKeluar, p);
                    }
                    break;

                case 3:
                    pengelola.tampilkanDaftar();
                    break;

                case 4:
                    System.out.println("Total pendapatan: Rp" + pengelola.hitungPendapatan());
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan ParkirPintar.");
                    break;

                default:
                    System.out.println("Pilihan menu tidak ada.");
            }
        }
    }
}
