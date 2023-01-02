package com.example.myapplication.models;

public class list_mahasiswa_ta {

    String gambar;
    String namamahasiswa;
    String judul_ta;
    String pembimbing;

    public list_mahasiswa_ta(String gambar, String namamahasiswa, String judul_ta, String pembimbing) {
        this.gambar = gambar;
        this.namamahasiswa = namamahasiswa;
        this.judul_ta = judul_ta;
        this.pembimbing = pembimbing;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNamamahasiswa() {
        return namamahasiswa;
    }

    public void setNamamahasiswa(String namamahasiswa) {
        this.namamahasiswa = namamahasiswa;
    }

    public String getJudul_ta() {
        return judul_ta;
    }

    public void setJudul_ta(String judul_ta) {
        this.judul_ta = judul_ta;
    }

    public String getPembimbing() {
        return pembimbing;
    }

    public void setPembimbing(String pembimbing) {
        this.pembimbing = pembimbing;
    }
}