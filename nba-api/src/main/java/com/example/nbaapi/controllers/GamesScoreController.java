package com.example.nbaapi.controllers;

import com.example.nbaapi.models.Game;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static com.example.nbaapi.controllers.ApiEndpoints.BOXSCORE;


@RequestMapping("/api")
@RestController
public class GamesScoreController {
    @Value("${SPORTSRADAR_API_KEY}")
    private String api_key;

    @Value("${NEWS_API_KEY}")
    private String news_api_key;

    // In order to return custom json not mapped to an object you ahve to return it as a string, and add
    // the annotations above
    @GetMapping(value="/gameboxscore/{game_id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getBoxScore(@PathVariable String game_id) throws IOException {
        String sURL =  ApiEndpoints.BOXSCORE + game_id + "/boxscore.json?api_key=" + api_key;
        return getJsonFromUrl(sURL);
    }

    @GetMapping(value="/gameboxsummary/{game_id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getSummary(@PathVariable String game_id) throws IOException {
        String sURL =  ApiEndpoints.BOXSCORE + game_id + "/summary.json?api_key=" + api_key;
        URL url = new URL(sURL);
        return getJsonFromUrl(sURL);
    }


    @GetMapping(value="/seasonalstats/{team_id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getSeasonalStats(@PathVariable String team_id) throws IOException {
        String sURL =  ApiEndpoints.SEASONAL_STATS + team_id + "/statistics.json?api_key=" + api_key;
        return getJsonFromUrl(sURL);
    }

    @GetMapping(value="/seasonalstanding", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getSeasonalStanding() throws IOException {
        String sURL =  ApiEndpoints.SEASONAL_STANDING + api_key;
        return getJsonFromUrl(sURL);
    }

    @GetMapping(value="/playbyplay/{game_id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getPlayByPlay(@PathVariable String game_id) throws IOException {
        String sURL =  ApiEndpoints.PLAY_BY_PLAY + game_id + "/pbp.json?api_key=" + api_key;
        return getJsonFromUrl(sURL);
    }


    @GetMapping(value="/roster/{team_id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getRoster(@PathVariable String team_id) throws IOException {
        String sURL =  ApiEndpoints.ROSTER + team_id + "/profile.json?api_key=" + api_key;
        return getJsonFromUrl(sURL);
    }

    @GetMapping(value="/news/{team_name}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getNews(@PathVariable String team_name) throws IOException {
        String sURL =  "https://newsapi.org/v2/everything?sources=bleacher-report&q=" +team_name + "&apiKey=" + news_api_key;
        return getJsonFromUrl(sURL);
    }

    private String getJsonFromUrl(String sURL) throws IOException{
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        return root.getAsJsonObject().toString();
    }


}
