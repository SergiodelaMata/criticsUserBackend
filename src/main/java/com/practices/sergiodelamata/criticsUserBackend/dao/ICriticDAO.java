package com.practices.sergiodelamata.criticsUserBackend.dao;

import com.practices.sergiodelamata.criticsUserBackend.model.Critic;

import java.util.List;

public interface ICriticDAO {

    List<Critic> searchAll();

    Critic searchCriticById(Integer idCritic);

    List<Critic> searchCriticByIdFilm(Integer idFilm);

    void saveCritic(Critic critic);

    void updateCritic(Critic critic);

    void deleteCritic(Integer idCritic);
}
