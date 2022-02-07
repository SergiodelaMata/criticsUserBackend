package com.practices.sergiodelamata.criticsUserBackend.controller;

import com.practices.sergiodelamata.criticsUserBackend.model.Critic;
import com.practices.sergiodelamata.criticsUserBackend.model.User;
import com.practices.sergiodelamata.criticsUserBackend.service.ICriticService;
import com.practices.sergiodelamata.criticsUserBackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.ParseException;
import java.util.*;

@RestController
public class CriticController {
    @Autowired
    ICriticService criticService;

    @Autowired
    IUserService userService;

    @GetMapping("/critics")
    public List<Critic> searchAll(){
        return criticService.searchAll();
    }

    @GetMapping("/critics/{idCritic}")
    public Critic searchCriticById(@PathVariable("idCritic") Integer idCritic)
    {
        return criticService.searchCriticById(idCritic);
    }

    @GetMapping("/critics/film/{idFilm}")
    public List<Critic> searchCriticByIdFilm(@PathVariable("idFilm") Integer idFilm)
    {
        return criticService.searchCriticByIdFilm(idFilm);
    }

    @PostMapping("/critics")
    public void saveCritic(@RequestBody Critic critic) throws ParseException {
        critic.setDateCritic(new Date());
        if(critic.getUser().getIdUser() != null) //En caso de que no se haya realizado la crítica con usuario no se guarda
        {
            //En el caso de que no se hayan proporcionado los datos del usuario, se pedirán para usarlos para guardar los datos de crítica
            if(critic.getUser().getUsername() == null || critic.getUser().getEmail() == null
                    || critic.getUser().getPassword() == null || critic.getUser().getEnable() == null )
            {
                User user = userService.searchUserById(critic.getUser().getIdUser());
                critic.setUser(user);
            }
            criticService.saveCritic(critic);
        }

    }

    @PutMapping("/critics")
    public void updateCritic(@RequestBody Critic critic)
    {
        if(critic.getUser().getIdUser() != null) //En caso de que no se haya realizado la crítica con usuario no se guarda
        {
            //En el caso de que no se hayan proporcionado los datos del usuario, se pedirán para usarlos para guardar los datos de crítica
            if(critic.getUser().getUsername() == null || critic.getUser().getEmail() == null
                    || critic.getUser().getPassword() == null || critic.getUser().getEnable() == null )
            {
                User user = userService.searchUserById(critic.getUser().getIdUser());
                critic.setUser(user);
            }
            criticService.updateCritic(critic);
        }
    }

    @DeleteMapping("/critics/{idCritic}")
    public void deleteCritic(@PathVariable("idCritic") Integer idCritic)
    {
        criticService.deleteCritic(idCritic);
    }
}
