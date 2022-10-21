package com.example.myapplication.models;

public class jadwal_seminar {
    String gambar;
    String mhsSeminar;
    String judultugasakhir;
    String ruangan;
    String Dospenguji;

    public jadwal_seminar(){}

    public jadwal_seminar(String gambar, String mhsSeminar, String judultugasakhir, String ruangan, String dospenguji) {
        this.gambar = gambar;
        this.mhsSeminar = mhsSeminar;
        this.judultugasakhir = judultugasakhir;
        this.ruangan = ruangan;
        Dospenguji = dospenguji;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getMhsSeminar() {
        return mhsSeminar;
    }

    public void setMhsSeminar(String mhsSeminar) {
        this.mhsSeminar = mhsSeminar;
    }

    public String getJudultugasakhir() {
        return judultugasakhir;
    }

    public void setJudultugasakhir(String judultugasakhir) {
        this.judultugasakhir = judultugasakhir;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public String getDospenguji() {
        return Dospenguji;
    }

    public void setDospenguji(String dospenguji) {
        Dospenguji = dospenguji;
    }
}
