package com.example.nbaapi.models.deserializers;

import com.example.nbaapi.models.TeamStanding;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StandingDeserializer implements JsonDeserializer<List<TeamStanding>> {

//    public static void customDeSerialize() throws IOException{
//        List<TeamStanding> teamStanding = new ArrayList<>();
//        Gson gson = new Gson();
//        JsonReader reader = new JsonReader(new FileReader("./standings.json"));
//        JsonObject myobj = gson.fromJson(reader, JsonObject.class);
//        JsonArray confs = myobj.getAsJsonObject("reg").getAsJsonArray("conferences");
//        for (JsonElement obj : confs) {
//            for (JsonElement div : obj.getAsJsonObject().getAsJsonArray("divisions")) {
//                for (JsonElement team : div.getAsJsonObject().getAsJsonArray("teams")) {
//                    teamStanding.add(gson.fromJson(team, TeamStanding.class));
//                }
//            }
//        }
//        System.out.println(Arrays.toString(teamStanding.toArray()));
//    }


    @Override
    public List<TeamStanding> deserialize(JsonElement json, Type TeamStanding, JsonDeserializationContext context) throws JsonParseException {
        List<TeamStanding> teamStanding = new ArrayList<>();
        Gson gson = new Gson();
        JsonObject myobj = gson.fromJson(json, JsonObject.class);
        JsonArray confs = myobj.getAsJsonObject("reg").getAsJsonArray("conferences");
        for (JsonElement obj : confs) {
            for (JsonElement div : obj.getAsJsonObject().getAsJsonArray("divisions")) {
                for (JsonElement team : div.getAsJsonObject().getAsJsonArray("teams")) {
                    teamStanding.add(gson.fromJson(team, TeamStanding.class));
                }
            }
        }
        return teamStanding;
    }
}
