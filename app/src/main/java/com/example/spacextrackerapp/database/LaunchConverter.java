package com.example.spacextrackerapp.database;

import androidx.room.TypeConverter;

import com.example.spacextrackerapp.model.LaunchFailureDetails;
import com.example.spacextrackerapp.model.LaunchSite;
import com.example.spacextrackerapp.model.Links;
import com.example.spacextrackerapp.model.Rocket;
import com.example.spacextrackerapp.model.Telemetry;
import com.example.spacextrackerapp.model.Timeline;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class LaunchConverter {
    private Gson gson =  new Gson();

    @TypeConverter
    public static List<Object> toMissionIds(String value) {
        Type listType = new TypeToken<List<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromMissionIds(List<Object> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

  /*  @TypeConverter
    public MissionIds storedStringToMissionIds(String value) {
        List<String> langs = Arrays.asList(value.split("\\s*,\\s*"));
        return new MissionIds(langs);
    }

    @TypeConverter
    public String missionIdsToStoredString(MissionIds missionIds) {
        String value = "";
        for (String lang :missionIds.getMissionId())
            value += lang + ",";
        return value;
    }*/

    @TypeConverter
    public Rocket toRocket(String value) {
        return gson.fromJson(value,Rocket.class );
    }

    @TypeConverter
    public String fromRocket(Rocket rocket) {
        return gson.toJson(rocket);
    }
/*
    @TypeConverter
    public Ships toShip(String value) {
        return gson.fromJson(value,Ships.class );
    }

    @TypeConverter
    public String fromShip(Ships ship) {
        return gson.toJson(ship);
    }*/

    @TypeConverter
    public Telemetry toTelemetry(String value) {
        return gson.fromJson(value,Telemetry.class );
    }

    @TypeConverter
    public String fromTelemetry(Telemetry telemetry) {
        return gson.toJson(telemetry);
    }

    @TypeConverter
    public LaunchSite toLaunchSite(String value) {
        return gson.fromJson(value,LaunchSite.class );
    }

    @TypeConverter
    public String fromLaunchSite(LaunchSite launchSite) {
        return gson.toJson(launchSite);
    }

    @TypeConverter
    public LaunchFailureDetails toLaunchFailureDetails(String value) {
        return gson.fromJson(value,LaunchFailureDetails.class );
    }

    @TypeConverter
    public String fromLaunchSite(LaunchFailureDetails launchFailureDetails) {
        return gson.toJson(launchFailureDetails);
    }

    @TypeConverter
    public Links toLinks(String value) {
        return gson.fromJson(value,Links.class );
    }

    @TypeConverter
    public String fromLinks(Links links) {
        return gson.toJson(links);
    }

    @TypeConverter
    public Timeline toTimeline(String value) {
        return gson.fromJson(value,Timeline.class );
    }

    @TypeConverter
    public String fromTimeline(Timeline timeline) {
        return gson.toJson(timeline);
    }

    @TypeConverter
    public Object toObject(String value) {
        return gson.fromJson(value,Object.class );
    }

    @TypeConverter
    public String fromObject(Object object) {
        return gson.toJson(object);
    }
}
