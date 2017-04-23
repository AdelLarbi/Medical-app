package com.app.yasmina.medical.activity;

import java.util.ArrayList;

public class CardContent {
    private int id;
    private String title;
    private ArrayList<String> informations;
    private ArrayList<String> images;

    public CardContent(int id, String title, String information) {
        this.id = id;
        this.title = title;
        this.informations = new ArrayList<>(); this.informations.add(information); // TODO
        this.images = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getInformations() {
        return informations;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInformation(String information) {
        this.informations.add(information);
    }

    public void setImage(String image) {
        this.images.add(image);
    }
}
