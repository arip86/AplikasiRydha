package com.example.akhmadarip.zakat.Model;

/**
 * Created by ole on 1/1/19.
 */

public class Activity {
    private String judul;
    private int gambar;

    public Activity(int gambar, String judul) {
        this.gambar=gambar;
        this.judul = judul;
    }

    public int getGambar() {
        return gambar;
    }

    public String getJudul() {
        return judul;
    }
}
