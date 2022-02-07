package com.practices.sergiodelamata.criticsUserBackend.dao;

import com.practices.sergiodelamata.criticsUserBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserJPA extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findByUsernameIsContaining(String username);

    List<User> findByEmailIsContaining(String email);

    User findByEmailAndPassword(String email, String password);
}