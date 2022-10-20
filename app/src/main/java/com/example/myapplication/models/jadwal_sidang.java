package com.example.myapplication.models;

public class jadwal_sidang {

    String gambar;
    String mhsSidang;
    String judultugasakhir;
    String ruangan;
    String Dospenguji;

    public jadwal_sidang() {
    }

    public jadwal_sidang(String gambar, String mhsSidang, String judultugasakhir, String ruangan, String Dospenguji) {
        this.gambar = gambar;
        this.mhsSidang = mhsSidang;
        this.judultugasakhir = judultugasakhir;
        this.ruangan = ruangan;
        this.Dospenguji = Dospenguji;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getMhsSidang() {
        return mhsSidang;
    }

    public void setMhsSidang(String mhsSidang) {
        this.mhsSidang = mhsSidang;
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
