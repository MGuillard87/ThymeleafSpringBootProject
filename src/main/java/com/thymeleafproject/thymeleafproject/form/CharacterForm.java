package com.thymeleafproject.thymeleafproject.form;

/* La classe  CharacterForm représentent des données de  FORM lorsque vous créez une nouvelle  character sur la page
    addCharacter
* */
public class CharacterForm {
    private int id;
    private String nom;
    private String type;


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
