package fr.epsi.project.phototheque.v1.dto;

public class CategoryDto {
    private String Name;

    private Long id;

    public CategoryDto() {

    }

    public CategoryDto(String Name) {
        this(null, Name);
    }


    public CategoryDto(Long id, String Name) {
        this.id = id;
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
