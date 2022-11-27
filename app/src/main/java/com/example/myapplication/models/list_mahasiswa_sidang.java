package com.example.myapplication.models;

import java.util.Date;

public class list_mahasiswa_sidang {
    String namaMSidang;
    String judul;
    String jadwal;
    Integer photo;

    public String getNamaMSidang() {
        return namaMSidang;
    }

    public void setNamaMSidang(String namaMSidang) {
        this.namaMSidang = namaMSidang;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }
}