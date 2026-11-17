/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartparks;

// Kelas Pembayaran: menyimpan metode bayar dan besar potongan (diskon)
public class Pembayaran {
    private String metode;       // "Tunai", "Non-Tunai", atau "QRIS"
    private int persenPotongan;  // potongan dalam persen

    // Konstruktor: persen potongan ditentukan otomatis dari metode
    public Pembayaran(String metode) {
        this.metode = metode;
        if (metode.equals("Tunai")) {
            persenPotongan = 0;
        } else if (metode.equals("Non-Tunai")) {
            persenPotongan = 5;
        } else {
            persenPotongan = 10; // QRIS
        }
    }

    // Menghitung besar potongan dari biaya parkir
    public int hitungPotongan(int biaya) {
        return biaya * persenPotongan / 100;
    }

    // Menghitung total bayar setelah dipotong
    public int hitungTotal(int biaya) {
        return biaya - hitungPotongan(biaya);
    }

    // Getter dan setter
    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public int getPersenPotongan() {
        return persenPotongan;
    }

    public void setPersenPotongan(int persenPotongan) {
        this.persenPotongan = persenPotongan;
    }
}
