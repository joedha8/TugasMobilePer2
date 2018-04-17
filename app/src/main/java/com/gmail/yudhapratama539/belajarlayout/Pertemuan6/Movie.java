package com.gmail.yudhapratama539.belajarlayout.Pertemuan6;

/**
 * Created by joedhaalzelvin on 11/04/18.
 */

public class Movie {
    private String title, year, genre, rating;
    private int gambar;

    public Movie() {
    }

    public Movie(String title, String year, String genre, String rating, int gambar) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.gambar = gambar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
