package com.practices.sergiodelamata.criticsUserBackend.dao;

import com.practices.sergiodelamata.criticsUserBackend.model.Critic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CriticDAOImpl implements ICriticDAO{
    @Autowired
    ICriticJPA criticJPA;

    @Override
    public List<Critic> searchAll() {
        return criticJPA.findAll();
    }

    @Override
    public Critic searchCriticById(Integer idCritic) {
        Optional<Critic> optional = criticJPA.findById(idCritic);
        if(optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Critic> searchCriticByIdFilm(Integer idFilm) {
        return criticJPA.findByIdFilm(idFilm);
    }

    @Override
    public void saveCritic(Critic critic) {
        criticJPA.save(critic);
    }

    @Override
    public void updateCritic(Critic critic) {
        criticJPA.save(critic);
    }

    @Override
    public void deleteCritic(Integer idCritic) {
        criticJPA.deleteById(idCritic);
    }
}
