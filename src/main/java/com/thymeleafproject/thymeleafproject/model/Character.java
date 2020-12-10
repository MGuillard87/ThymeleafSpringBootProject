package com.thymeleafproject.thymeleafproject.model;

public class Character {
    private int id;
    private String nom;
    private String type;

    public Character() {

    }

    public Character(int id, String nom, String type) {
        this.id = id;
        this.nom = nom;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
