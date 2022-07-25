package com.example.petapp;

public class Mascota {
    private String name;
    private int foto;
    private int likes;
    private boolean isButtonClicked;

    public Mascota(String name, int foto, int likes) {
        this.name = name;
        this.foto = foto;
        this.likes = likes;
        this.isButtonClicked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isButtonClicked() {
        return isButtonClicked;
    }

    public void setButtonClicked(boolean buttonClicked) {
        isButtonClicked = buttonClicked;
    }
}
