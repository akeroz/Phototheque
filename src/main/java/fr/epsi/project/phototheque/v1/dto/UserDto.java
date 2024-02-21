package fr.epsi.project.phototheque.v1.dto;

public class UserDto {
    private String firstname;
    private String lastname;

    private String password;

    private String pseudo;

    private Long id;

    public UserDto() {

    }

    public UserDto(String firstname, String lastname, String password, String pseudo) {
        this(null, firstname, lastname, password, pseudo);
    }

    public UserDto(Long id, String firstname, String lastname, String password, String pseudo) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        if (password.length() < 6 || !password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 6 caractères avec un caractère spécial.");
        }
        this.password = password;
        this.pseudo = pseudo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPseudo(){return pseudo;}

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
