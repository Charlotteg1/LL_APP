package models;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String forename;

    @Column
    private String surname;

    @Column
    private Long level;

    @OneToOne(mappedBy = "user")
    private Login login;

    public User(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
        this.level = 0L;
    }

// default constructor
    public User() {
    }

// getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
