package fr.epsi.project.phototheque.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "images")
public class Image implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private byte[] content;
    private String categorie;

    private String description;
    private String date;
    private Boolean hasHuman;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCategorie() {
        return categorie;
    }

    public byte[] getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Boolean getHasHuman() {
        return hasHuman;
    }

    public void setHasHuman(Boolean hasHuman) {
        this.hasHuman = hasHuman;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
