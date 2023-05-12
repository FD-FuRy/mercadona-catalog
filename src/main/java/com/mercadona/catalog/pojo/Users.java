package com.mercadona.catalog.pojo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class Users {
    //Id clé primaire de la base "Users" (auto-générée par séquence):
    @Id
    @SequenceGenerator(name="user_sequence",
    sequenceName = "user_sequence",
    allocationSize = 113)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "user_sequence")
    @Column(name = "userId", updatable = false)
    private Long userId;

    @Column(name="userName")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="userRoles",
            joinColumns = {@JoinColumn(name="userId", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId", referencedColumnName = "roleId")})
    private List<UserRole> roles =  new ArrayList<>();

    // constructeurs de la classe Utilisateurs:
    public Users() {
        //Constructeur vide requis par hibernate
    }

    public Users(String userName, String email, String password, List<UserRole> roles) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Users(Long userId, String userName, String email, String password, List<UserRole> roles) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    //Getters/Setters du nombre identifiant de l'utilisateur:
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    //Getters/Setters du nom de l'utilisateur:
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    //Getters/Setters de l'email utilisateur:

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    //Getters/Setters du mot de passe de l'utilisateur:
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    //Getters/Setters du/des roles/grades de l'utilisateur:
    public List<UserRole> getRoles() { return roles; }
    public void setRoles(List<UserRole> roles) { this.roles = roles; }

}
