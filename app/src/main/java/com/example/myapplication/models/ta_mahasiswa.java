package com.example.myapplication.models;

public class ta_mahasiswa {
    String gambar;
    String nama;
    String judul;
    String id_mhs;
    String year;
    String NIM;

    public ta_mahasiswa() { }

    public ta_mahasiswa(String gambar, String nama, String judul, String id_mhs, String NIM, String year) {
        this.gambar = gambar;
        this.nama = nama;
        this.judul = judul;
        this.NIM = NIM;
        this.id_mhs = id_mhs;
        this.year = year;
    }

    public String getId_mhs() {
        return id_mhs;
    }

    public void setId_mhs(String id_mhs) {
        this.id_mhs = id_mhs;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
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


}
