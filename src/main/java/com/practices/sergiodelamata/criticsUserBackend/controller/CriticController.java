package com.practices.sergiodelamata.criticsUserBackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practices.sergiodelamata.criticsUserBackend.model.Critic;
import com.practices.sergiodelamata.criticsUserBackend.model.Rol;
import com.practices.sergiodelamata.criticsUserBackend.model.User;
import com.practices.sergiodelamata.criticsUserBackend.service.ICriticService;
import com.practices.sergiodelamata.criticsUserBackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        if(critic.getIdUser().getIdUser() != null) //En caso de que no se haya realizado la crítica con usuario no se guarda
        {
            //En el caso de que no se hayan proporcionado los datos del usuario, se pedirán para usarlos para guardar los datos de crítica
            if(critic.getIdUser().getUsername() == null || critic.getIdUser().getEmail() == null
                    || critic.getIdUser().getPassword() == null || critic.getIdUser().getEnable() == null )
            {
                User user = userService.searchUserById(critic.getIdUser().getIdUser());
                critic.setIdUser(user);
            }
            criticService.saveCritic(critic);
        }

    }

    @PutMapping("/critics")
    public void updateCritic(@RequestBody Critic critic)
    {
        if(critic.getIdUser().getIdUser() != null) //En caso de que no se haya realizado la crítica con usuario no se guarda
        {
            //En el caso de que no se hayan proporcionado los datos del usuario, se pedirán para usarlos para guardar los datos de crítica
            if(critic.getIdUser().getUsername() == null || critic.getIdUser().getEmail() == null
                    || critic.getIdUser().getPassword() == null || critic.getIdUser().getEnable() == null )
            {
                User user = userService.searchUserById(critic.getIdUser().getIdUser());
                critic.setIdUser(user);
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
