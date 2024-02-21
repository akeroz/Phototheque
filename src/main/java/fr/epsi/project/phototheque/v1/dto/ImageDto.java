package fr.epsi.project.phototheque.v1.dto;

import jakarta.persistence.*;

public class ImageDto {

    private Long id;
    private String name;
    private byte[] content;
    private String categorie;
    private String description;
    private String date;
    private boolean hasHuman;


    public ImageDto(Long id, String name, byte[] content, String categorie, String description, String date, boolean hasHuman){
        this.categorie = categorie;
        this.id = id;
        this.description = description;
        this.date = date;
        this.hasHuman = hasHuman;
        this.content = content;
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getContent() {
        return content;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHasHuman(boolean hasHuman) {
        this.hasHuman = hasHuman;
    }

    public void setName(String name) {
        this.name = name;
    }
}


