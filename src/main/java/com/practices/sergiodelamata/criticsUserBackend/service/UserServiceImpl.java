package com.practices.sergiodelamata.criticsUserBackend.service;

import com.practices.sergiodelamata.criticsUserBackend.dao.IUserDAO;
import com.practices.sergiodelamata.criticsUserBackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    IUserDAO userDAO;

    @Override
    public List<User> searchAll() {
        return userDAO.searchAll();
    }

    @Override
    public User searchUserById(Integer idUser) {
        return userDAO.searchUserById(idUser);
    }

    @Override
    public User searchUserByUsernameUnique(String username)
    {
        return userDAO.searchUserByUsernameUnique(username);
    }

    @Override
    public User searchUserByEmailUnique(String email)
    {
        return userDAO.searchUserByEmailUnique(email);
    }

    @Override
    public List<User> searchUserByUsername(String username) {
        return userDAO.searchUserByUsername(username);
    }

    @Override
    public List<User> searchUserByEmail(String email) {
        return userDAO.searchUserByEmail(email);
    }

    @Override
    public User searchUserByEmailPassword(String email, String password)
    {
        return userDAO.searchUserByEmailPassword(email, password);
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(Integer idUser) {
        userDAO.deleteUser(idUser);
    }

    @Override
    public void deleteCritic(Integer idUser, Integer idCritic) {
        userDAO.deleteCritic(idUser, idCritic);
    }
}
