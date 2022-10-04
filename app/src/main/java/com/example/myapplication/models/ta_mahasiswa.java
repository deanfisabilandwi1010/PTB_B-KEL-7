package com.example.myapplication.models;

public class ta_mahasiswa {
    String gambar;
    String nama;
    String judul;
    String doping;

    public ta_mahasiswa() { }

    public ta_mahasiswa(String gambar, String nama, String judul, String doping) {
        this.gambar = gambar;
        this.nama = nama;
        this.judul = judul;
        this.doping = doping;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDoping() {
        return doping;
    }

    public void setDoping(String doping) {
        this.doping = doping;
    }
}
