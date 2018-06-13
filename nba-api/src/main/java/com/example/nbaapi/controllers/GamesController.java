package com.example.nbaapi.controllers;

import com.example.nbaapi.models.Game;
import com.example.nbaapi.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class GamesController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    public Iterable<Game> findAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/games/{alias}")
    public Iterable<Game> findGameByAlias(@PathVariable String alias){
        return gameRepository.findByHomeTeamAliasOrAwayTeamAlias(alias, alias);
    }
}
