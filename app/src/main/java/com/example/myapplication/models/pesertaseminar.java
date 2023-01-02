package com.example.myapplication.models;

public class pesertaseminar {

    String nama;
    String nim;


    public pesertaseminar() { }

    public pesertaseminar(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
