package fr.epsi.project.phototheque.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.mapping.Join;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "images")
public class Image implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    private byte[] content;

    @ManyToOne()
    @JsonIgnore
    private Category category;
    private String description;
    private String create_date;
    private Boolean hasHuman;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public byte[] getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return create_date;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.create_date = date;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
