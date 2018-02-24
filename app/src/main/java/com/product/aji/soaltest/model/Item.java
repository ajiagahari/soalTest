package com.product.aji.soaltest.model;

/**
 * Created by LP on 2/24/2018.
 */

public class Item {
    private String judul;
    private String pemasok;
    private String jumlah;
    private String tanggal;
    public String judulhint;
    public String pemasokhint;
    public String jumlahhint;
    public String tanggalhint;

    public Item(String judul, String pemasok, String jumlah, String tanggal) {
        this.judul = judul;
        this.pemasok = pemasok;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPemasok() {
        return pemasok;
    }

    public void setPemasok(String pemasok) {
        this.pemasok = pemasok;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
