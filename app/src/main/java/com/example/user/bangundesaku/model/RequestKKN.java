package com.example.user.bangundesaku.model;

/**
 * Created by user on 22/07/2018.
 */

public class RequestKKN {
    private String namaDesa, alamat, judul, deskripsi, kategori;
    private int id;
    private int image;

    public RequestKKN(String namaDesa, String alamat, String judul, String deskripsi, String kategori, int image) {
        this.namaDesa = namaDesa;
        this.alamat = alamat;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.image = image;
    }

    public RequestKKN(String namaDesa, String alamat, String judul, String deskripsi, String kategori) {
        this.namaDesa = namaDesa;
        this.alamat = alamat;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
    }

    public RequestKKN() {

    }

    public String getNamaDesa() {

        return namaDesa;
    }

    public void setNamaDesa(String namaDesa) {
        this.namaDesa = namaDesa;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
