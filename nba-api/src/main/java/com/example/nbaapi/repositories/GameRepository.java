package com.example.nbaapi.repositories;

import com.example.nbaapi.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByHomeTeamAliasOrAwayTeamAlias(String alias, String otheralias);



}
