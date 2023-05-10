package com.mercadona.catalog.pojo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Roles")
public class UserRole {
    //Id clé primaire de la base "UserRoles" (auto-générée par séquence):
    @Id
    @SequenceGenerator(name="role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 113)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "role_sequence")
    @Column(name = "roleId", updatable = false)
    private Long roleId;

    @Column(name="roleName")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<Users> users = new ArrayList<>();

    // constructeurs de la classe Utilisateurs:
    public UserRole() {
        //Constructeur vide requis par hibernate
    }

    public UserRole(String roleName, List<Users> users) {
        this.roleName = roleName;
        this.users = users;
    }

    public UserRole(Long roleId, String roleName, List<Users> users) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.users = users;
    }

    //Getters/Setters du nombre identifiant du Role:
    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }

    //Getters/Setters du nom du Role:
    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    //Getters/Setters du/des utilisateurs ayant ce Role:
    public List<Users> getUsers() { return users; }
    public void setUsers(List<Users> users) { this.users = users; }

}
