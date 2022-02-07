package com.practices.sergiodelamata.criticsUserBackend.dao;

import com.practices.sergiodelamata.criticsUserBackend.model.User;

import java.util.List;

public interface IUserDAO {

    List<User> searchAll();

    User searchUserById(Integer idUser);

    User searchUserByUsernameUnique(String username);

    User searchUserByEmailUnique(String email);

    List<User> searchUserByUsername(String username);

    List<User> searchUserByEmail(String email);

    User searchUserByEmailPassword(String email, String password);

    void saveUser(User user);

    void deleteUser(Integer idUser);

    void updateUser(User user);

    void deleteCritic(Integer idUser, Integer idCritic);
}
