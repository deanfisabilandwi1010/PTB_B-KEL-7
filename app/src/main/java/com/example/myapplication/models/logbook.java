package com.example.myapplication.models;


public class logbook {

    String book;
    String done;
    String tanggal;
    String rincian;


    public logbook(String book,String done, String tanggal, String rincian) {
        this.book = book;
        this.done = done;
        this.tanggal = tanggal;
        this.rincian = rincian;

    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
    public String getDone() {
        return done;
    }
    public void setDone(String done) {
        this.done = done;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getRincian() {
        return rincian;
    }

    public void setRincian(String rincian) {
        this.rincian = rincian;
    }


}
