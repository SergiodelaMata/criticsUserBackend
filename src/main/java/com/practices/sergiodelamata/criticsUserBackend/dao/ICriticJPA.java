package com.practices.sergiodelamata.criticsUserBackend.dao;

import com.practices.sergiodelamata.criticsUserBackend.model.Critic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICriticJPA extends JpaRepository<Critic, Integer> {
    List<Critic> findByIdFilm(int idFilm);
}