//package com.example.nbaapi.services;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.concurrent.CompletableFuture;
//
//@Service
//public class SportsRadarLookupService {
//
//    private static final Logger logger = LoggerFactory.getLogger(SportsRadarLookupService.class);
//    private ObjectMapper mapper;
////    private final RestTemplate restTemplate;
//
//    public SportsRadarLookupService(){
////        this.restTemplate = restTemplate;
//        mapper = new ObjectMapper();
//    }
//
//    @Async
//    public CompletableFuture<JsonObject> getStanding(String type) throws InterruptedException, IOException {
//        logger.info("Looking up " + type + " standing");
//        String sURL = String.format("http://api.sportradar.us/nba/trial/v4/en/seasons/2017/" + type + "/standings.json?api_key=fv87shvzfuu3ebusje3v4saw");
//        JsonObject rootobj = getJsonFromUrl(sURL);
//        Thread.sleep(1000L);
//        return CompletableFuture.completedFuture(rootobj);
//    }
//
//    private JsonObject getJsonFromUrl(String sURL) throws IOException{
//        URL url = new URL(sURL);
//        URLConnection request = url.openConnection();
//        JsonParser jp = new JsonParser(); //from gson
//        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
//        return root.getAsJsonObject();
//    }
//}
