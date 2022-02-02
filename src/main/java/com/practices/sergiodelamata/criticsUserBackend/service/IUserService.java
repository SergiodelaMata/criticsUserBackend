package com.practices.sergiodelamata.criticsUserBackend.service;

import com.practices.sergiodelamata.criticsUserBackend.model.User;

import java.util.List;

public interface IUserService {

    List<User> searchAll();

    User searchUserById(Integer idUser);

    User searchUserByUsername(String username);

    User searchUserByEmail(String email);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer idUser);

    void deleteCritic(Integer idUser, Integer idCritic);
}
