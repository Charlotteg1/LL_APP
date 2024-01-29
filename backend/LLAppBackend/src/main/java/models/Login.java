package models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="login")
public class Login {
    @Column(name="login_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;

    @Column
    private String email;

    @Column
    private String password;

    @Column(name="date_joined")
    private LocalDate dateJoined;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
        this.dateJoined = LocalDate.now();
    }

//    default constructor

    public Login() {
    }

//    getters and setters


    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
