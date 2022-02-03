package com.practices.sergiodelamata.criticsUserBackend.dao;

import com.practices.sergiodelamata.criticsUserBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJPA extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}