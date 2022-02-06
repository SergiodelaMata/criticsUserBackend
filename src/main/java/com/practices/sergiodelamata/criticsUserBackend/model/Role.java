package com.practices.sergiodelamata.criticsUserBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authorities")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol", nullable = false)
    private Integer idRole;

    @Lob
    @Column(name = "authority", nullable = false)
    private String authority;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRol) {
        this.idRole = idRol;
    }
}