package com.example.mrm_oreo;

public class ItemMenu {

    String name;
    String keterangan;
    int image;

    public ItemMenu(String name, String keterangan, int image) {
        this.name = name;
        this.keterangan = keterangan;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
