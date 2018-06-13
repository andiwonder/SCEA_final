package com.example.nbaapi.models;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity @Table(name = "GAMES")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE")
    private String date;

    @Column(name = "API_GAME_ID")
    private String apiGameId;

    @Column(name = "HOME_TEAM_ID")
    private String homeTeamId;

    @Column(name = "HOME_TEAM_ALIAS")
    private String homeTeamAlias;

    @Column(name = "HOME_POINTS")
    private String homePoints;

    @Column(name = "AWAY_TEAM_ID")
    private String awayTeamId;

    @Column(name = "AWAY_TEAM_ALIAS")
    private String awayTeamAlias;

    @Column(name = "AWAY_POINTS")
    private String awayPoints;
}
