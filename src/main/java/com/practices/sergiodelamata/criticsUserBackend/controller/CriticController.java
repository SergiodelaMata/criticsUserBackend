package com.practices.sergiodelamata.criticsUserBackend.controller;

import com.practices.sergiodelamata.criticsUserBackend.model.Critic;
import com.practices.sergiodelamata.criticsUserBackend.service.ICriticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriticController {
    @Autowired
    ICriticService criticService;

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
    public void saveCritic(@RequestBody Critic critic)
    {
        criticService.saveCritic(critic);
    }

    @PutMapping("/critics")
    public void updateCritic(@RequestBody Critic critic)
    {
        criticService.updateCritic(critic);
    }

    @DeleteMapping("/critics/{idCritic}")
    public void deleteCritic(@PathVariable("idCritic") Integer idCritic)
    {
        criticService.deleteCritic(idCritic);
    }
}
