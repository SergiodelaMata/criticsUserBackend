package com.practices.sergiodelamata.criticsUserBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "critics")
public class Critic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCritic", nullable = false)
    private Integer idCritic;

    @Column(name = "idFilm", nullable = false)
    private Integer idFilm;

    @ManyToOne(optional = false)
    //@JoinColumn(name = "idUser", nullable = false)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false)
    @JsonIgnoreProperties("critics")
    private User idUser;

    @Lob
    @Column(name = "valoration", nullable = false)
    private String valoration;

    @Column(name = "mark", nullable = false)
    private Integer mark;

    @Column(name = "dateCritic", nullable = false)
    private Date dateCritic;

    public Date getDateCritic() {
        return dateCritic;
    }

    public void setDateCritic(Date dateCritic) {
        this.dateCritic = dateCritic;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getValoration() {
        return valoration;
    }

    public void setValoration(String valoration) {
        this.valoration = valoration;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public Integer getIdCritic() {
        return idCritic;
    }

    public void setIdCritic(Integer idCritic) {
        this.idCritic = idCritic;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Critic)) return false;
        Critic critic = (Critic) o;
        return Objects.equals(idCritic, critic.idCritic) && Objects.equals(idFilm, critic.idFilm)
                && Objects.equals(valoration, critic.valoration) && Objects.equals(mark, critic.mark)
                && Objects.equals(dateCritic, critic.dateCritic) && Objects.equals(idUser, critic.idUser);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idCritic, idFilm, valoration, mark, dateCritic, idUser);
    }
}