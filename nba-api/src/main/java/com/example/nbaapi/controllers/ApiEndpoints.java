package com.example.nbaapi.controllers;

public enum ApiEndpoints {
    BOXSCORE("http://api.sportradar.us/nba/trial/v4/en/games/"),
    SUMMARY("http://api.sportradar.us/nba/trial/v4/en/games/"),
    ROSTER("http://api.sportradar.us/nba/trial/v4/en/teams/"),
    STANDINGS("http://api.sportradar.us/nba/trial/v4/en/seasons/2017/"),
    SEASONAL_STATS("http://api.sportradar.us/nba/trial/v4/en/seasons/2017/REG/teams/"),
    PLAY_BY_PLAY("http://api.sportradar.us/nba/trial/v4/en/games/"),
    SEASONAL_STANDING("http://api.sportradar.us/nba/trial/v4/en/seasons/2017/REG/standings.json?api_key=");


    private final String url;

    ApiEndpoints(final String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
