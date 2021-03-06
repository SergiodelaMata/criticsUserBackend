package com.practices.sergiodelamata.criticsUserBackend.controller;

import com.practices.sergiodelamata.criticsUserBackend.model.User;
import com.practices.sergiodelamata.criticsUserBackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/users")
    public List<User> searchAll()
    {
        return userService.searchAll();
    }

    @GetMapping("/users/{idUser}")
    public User searchUserById(@PathVariable("idUser") Integer idUser)
    {
        return userService.searchUserById(idUser);
    }

    @GetMapping("/users/username/{username}/unique")
    public User searchUserByUsernameUnique(@PathVariable("username") String username)
    {
        return userService.searchUserByUsernameUnique(username);
    }

    @GetMapping("/users/email/{email}/unique")
    public User searchUserByEmailUnique(@PathVariable("email") String email)
    {
        return userService.searchUserByEmailUnique(email);
    }

    @GetMapping("/users/username/{username}")
    public List<User> searchUserByUsername(@PathVariable("username") String username)
    {
        return userService.searchUserByUsername(username);
    }

    @GetMapping("/users/email/{email}")
    public List<User> searchUserByEmail(@PathVariable("email") String email)
    {
        return userService.searchUserByEmail(email);
    }

    @GetMapping("/users/login/{email}/{password}")
    public User searchUserByEmailWithPassword(@PathVariable("email") String email, @PathVariable("password") String password)
    {
        return userService.searchUserByEmailPassword(email, password);
    }


    @PostMapping("/users")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/users/{idUser}")
    public void deleteUser(@PathVariable("idUser") Integer idUser)
    {
        userService.deleteUser(idUser);
    }

    @DeleteMapping("/users/{idUser}/critic/{idCritic}")
    public void deleteCriticFromUser(@PathVariable("idUser") Integer idUser, @PathVariable("idCritic") Integer idCritic)
    {
        userService.deleteCritic(idUser, idCritic);
    }

}
