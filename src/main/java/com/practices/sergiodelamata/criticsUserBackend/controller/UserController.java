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

    @GetMapping("/users/username/{username}")
    public User searchUserByUsername(@PathVariable("username") String username)
    {
        return userService.searchUserByUsername(username);
    }

    @GetMapping("/users/email/{email}")
    public User searchUserByEmail(@PathVariable("email") String email)
    {
        return userService.searchUserByEmail(email);
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

}
