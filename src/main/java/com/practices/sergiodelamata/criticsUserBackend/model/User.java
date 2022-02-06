package com.practices.sergiodelamata.criticsUserBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser", nullable = false)
    private Integer idUser;

    @Lob
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    @Lob
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "enable")
    private Integer enable;

    @ManyToMany(fetch=FetchType.EAGER)
    /*@JoinTable(name = "users_has_authorities",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idRol"))*/
    @JoinTable(name = "users_has_authorities", joinColumns = {
            @JoinColumn(name="idUser", referencedColumnName = "idUser")},
            inverseJoinColumns = {@JoinColumn(name="idRol", referencedColumnName = "idRol")})
    @JsonIgnoreProperties("users")
    private List<Role> roles = new ArrayList<>();

    //@OneToMany(mappedBy = "idUser", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "idUser", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("idUser")
    private List<Critic> critics = new ArrayList<>();

    public List<Critic> getCritics() {
        return critics;
    }

    public void setCritics(List<Critic> critics) {
        this.critics = critics;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof User)) return false;
        User user = (User) o;
        return enable == user.enable && Objects.equals(idUser, user.idUser) && Objects.equals(username, user.username)
                && Objects.equals(password, user.password) && Objects.equals(email, user.email)
                && Objects.equals(critics, user.critics) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idUser, username, password, email, enable, critics, roles);
    }

    public void addCritic(Critic critic){
        getCritics().add(critic);
        critic.setIdUser(this);
    }

    public void removeCritic(Critic critic){
        if(critic != null){
            getCritics().remove(critic);
        }
    }
}