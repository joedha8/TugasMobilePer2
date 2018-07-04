package com.gmail.yudhapratama539.belajarlayout.Pertemuan12;

/**
 * Created by joedhaalzelvin on 04/07/18.
 */

public class User {
    public String nama;
    public String noTelp;

    public User(String nama, String noTelp) {
        this.nama = nama;
        this.noTelp = noTelp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}
