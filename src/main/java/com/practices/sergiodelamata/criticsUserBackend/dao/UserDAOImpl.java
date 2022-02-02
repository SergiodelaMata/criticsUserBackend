package com.practices.sergiodelamata.criticsUserBackend.dao;

import com.practices.sergiodelamata.criticsUserBackend.model.Critic;
import com.practices.sergiodelamata.criticsUserBackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements IUserDAO{
    @Autowired
    IUserJPA userJPA;

    @Autowired
    ICriticJPA criticJPA;


    @Override
    public List<User> searchAll()
    {
        return userJPA.findAll();
    }

    @Override
    public User searchUserById(Integer idUser){
        Optional<User> optional = userJPA.findById(idUser);
        if(optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }

    @Override
    public User searchUserByUsername(String username){
        return userJPA.findByUsername(username);
    }

    @Override
    public User searchUserByEmail(String email) {
        return userJPA.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        userJPA.save(user);
    }

    @Override
    public void deleteUser(Integer idUser) {
        userJPA.deleteById(idUser);
    }

    @Override
    public void updateUser(User user) {
        userJPA.save(user);
    }

    @Override
    public void deleteCritic(Integer idUser, Integer idCritic) {
        Optional<User> optionalUser = userJPA.findById(idUser);
        if(optionalUser.isPresent())
        {
            User user = optionalUser.get();
            Optional<Critic> optionalCritic = criticJPA.findById(idCritic);
            if(optionalCritic.isPresent())
            {
                user.removeCritic(optionalCritic.get());
                userJPA.save(user);
                criticJPA.deleteById(idCritic);
            }
        }
    }
}
