//package com.example.nbaapi.controllers;
//
//import com.example.nbaapi.services.SportsRadarLookupService;
//// import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//// import org.slf4j.Logger;
//// import org.slf4j.LoggerFactory;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutionException;
//
//@RestController
//public class StandingsController {
//
//    // get better logging
//    // private static final Logger logger = LoggerFactory.getLogger(Standing.class);
//
//    private final SportsRadarLookupService sportsRadarLookupService;
//
//    public StandingsController(){
//        this.sportsRadarLookupService = new SportsRadarLookupService();
//    }
//
//    @GetMapping("/standingstest")
//    public String returnRandomString() {
//        return "test test test";
//    }
//
//    @GetMapping(value="/standings", produces= MediaType.APPLICATION_JSON_VALUE)
//    public String getStanding() throws IOException, InterruptedException, ExecutionException{
//        CompletableFuture<JsonObject> reg_standing = sportsRadarLookupService.getStanding("REG");
//        CompletableFuture<JsonObject> pst_standing = sportsRadarLookupService.getStanding("PST");
//        CompletableFuture.allOf(reg_standing, pst_standing).join();
//
//        JsonObject reg_standing_json =  reg_standing.get();
//        JsonObject pst_standing_json = pst_standing.get();
//        JsonObject result = new JsonObject();
//        result.add("reg", reg_standing_json);
//        result.add("pst", pst_standing_json);
//        return result.toString();
//    }
//}
