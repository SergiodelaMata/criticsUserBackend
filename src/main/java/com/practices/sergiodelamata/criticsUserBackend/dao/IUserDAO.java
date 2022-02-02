package com.practices.sergiodelamata.criticsUserBackend.dao;

import com.practices.sergiodelamata.criticsUserBackend.model.User;

import java.util.List;

public interface IUserDAO {

    List<User> searchAll();

    User searchUserById(Integer idUser);

    User searchUserByUsername(String username);

    User searchUserByEmail(String email);

    void saveUser(User user);

    void deleteUser(Integer idUser);

    void updateUser(User user);

    void deleteCritic(Integer idUser, Integer idCritic);
}
