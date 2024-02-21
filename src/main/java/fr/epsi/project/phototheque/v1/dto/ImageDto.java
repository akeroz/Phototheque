package fr.epsi.project.phototheque.v1.dto;

import jakarta.persistence.*;

public class ImageDto {

    private Long id;
    private String name;
    private byte[] content;
    private long categorie;
    private String description;
    private String create_date;
    private Boolean hasHuman;


    public ImageDto(Long id, String name, byte[] content, Long categorie, String description, String date, boolean hasHuman){
        this.categorie = categorie;
        this.id = id;
        this.description = description;
        this.create_date = date;
        this.hasHuman = hasHuman;
        this.content = content;
        this.name = name;
    }

    public ImageDto(){

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

    public Long getCategorie() {
        return categorie;
    }

    public String getDate() {
        return create_date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategorie(Long categorie) {
        this.categorie = categorie;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.create_date = date;
    }

    public void setHasHuman(boolean hasHuman) {
        this.hasHuman = hasHuman;
    }

    public Boolean getHasHuman() {
        return hasHuman;
    }

    public long getCategorieId() {
        return categorie;
    }

    public void setName(String name) {
        this.name = name;
    }
}


