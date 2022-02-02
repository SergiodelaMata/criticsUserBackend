package com.practices.sergiodelamata.criticsUserBackend.service;

import com.practices.sergiodelamata.criticsUserBackend.dao.ICriticDAO;
import com.practices.sergiodelamata.criticsUserBackend.model.Critic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriticServiceImpl implements ICriticService{
    @Autowired
    ICriticDAO criticDAO;

    @Override
    public List<Critic> searchAll() {
        return criticDAO.searchAll();
    }

    @Override
    public Critic searchCriticById(Integer idCritic) {
        return criticDAO.searchCriticById(idCritic);
    }

    @Override
    public List<Critic> searchCriticByIdFilm(Integer idFilm) {
        return criticDAO.searchCriticByIdFilm(idFilm);
    }

    @Override
    public void saveCritic(Critic critic) {
        criticDAO.saveCritic(critic);
    }

    @Override
    public void updateCritic(Critic critic) {
        criticDAO.updateCritic(critic);
    }

    @Override
    public void deleteCritic(Integer idCritic) {
        criticDAO.deleteCritic(idCritic);
    }
}
