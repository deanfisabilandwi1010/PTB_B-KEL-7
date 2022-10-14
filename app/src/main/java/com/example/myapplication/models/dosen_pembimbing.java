package com.example.myapplication.models;

public class dosen_pembimbing {
    String profil;
    String namaDoping;
    String NIKDoping;
    String bidangDoping;

    public dosen_pembimbing() { }

    public dosen_pembimbing(String profil, String namaDoping, String NIKDoping, String bidangDoping) {
        this.profil = profil;
        this.namaDoping = namaDoping;
        this.NIKDoping = NIKDoping;
        this.bidangDoping = bidangDoping;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getNamaDoping() {
        return namaDoping;
    }

    public void setNamaDoping(String namaDoping) {
        this.namaDoping = namaDoping;
    }

    public String getNIKDoping() {
        return NIKDoping;
    }

    public void setNIKDoping(String NIKDoping) {
        this.NIKDoping = NIKDoping;
    }

    public String getBidangDoping() {
        return bidangDoping;
    }

    public void setBidangDoping(String bidangDoping) {
        this.bidangDoping = bidangDoping;
    }
}
