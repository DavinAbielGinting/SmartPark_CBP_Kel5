/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartparks;

// Kelas Kendaraan: menyimpan data satu kendaraan
public class Kendaraan {
    // Atribut dibuat private (enkapsulasi)
    private String platNomor;
    private String jenis; // "Motor" atau "Mobil"

    // Konstruktor: dipanggil saat objek dibuat dengan new
    public Kendaraan(String platNomor, String jenis) {
        this.platNomor = platNomor;
        this.jenis = jenis;
    }

    // Getter dan setter
    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}