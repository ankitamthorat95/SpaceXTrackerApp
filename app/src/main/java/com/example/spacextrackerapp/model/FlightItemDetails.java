package com.example.spacextrackerapp.model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "launches",indices = @Index(value = {"flightNumber"},unique = true))

public class FlightItemDetails implements Serializable {


    @SerializedName("flight_number")
        @Expose
        @PrimaryKey(autoGenerate = false)
        public Integer flightNumber;
        @SerializedName("mission_name")
        @Expose
        public String missionName;
        @SerializedName("mission_id")
        @Expose
        public List<Object> missionId;
       // public List<String> missionId;
        @SerializedName("upcoming")
        @Expose
        public Boolean upcoming;
        @SerializedName("launch_year")
        @Expose
        public String launchYear;
        @SerializedName("launch_date_unix")
        @Expose
        public Integer launchDateUnix;
        @SerializedName("launch_date_utc")
        @Expose
        public String launchDateUtc;
        @SerializedName("launch_date_local")
        @Expose
        public String launchDateLocal;
        @SerializedName("is_tentative")
        @Expose
        public Boolean isTentative;
        @SerializedName("tentative_max_precision")
        @Expose
        public String tentativeMaxPrecision;
        @SerializedName("tbd")
        @Expose
        public Boolean tbd;
        @SerializedName("launch_window")
        @Expose
        public Integer launchWindow;
        @SerializedName("rocket")
        @Expose
        public Rocket rocket;
        @SerializedName("ships")
        @Expose
        public List<Object> ships;
        @SerializedName("telemetry")
        @Expose
        public Telemetry telemetry;
        @SerializedName("launch_site")
        @Expose
        public LaunchSite launchSite;
        @SerializedName("launch_success")
        @Expose
        public Boolean launchSuccess = false;
        @SerializedName("launch_failure_details")
        @Expose
        public LaunchFailureDetails launchFailureDetails;
        @SerializedName("links")
        @Expose
        public Links links;
        @SerializedName("details")
        @Expose
        public String details;
        @SerializedName("static_fire_date_utc")
        @Expose
        public String staticFireDateUtc;
        @SerializedName("static_fire_date_unix")
        @Expose
        public Integer staticFireDateUnix;
        @SerializedName("timeline")
        @Expose
        public Timeline timeline;
        @SerializedName("crew")
        @Expose
        public Object crew;

    public Boolean isFavourite = false;

    public FlightItemDetails(Integer flightNumber, String missionName, List<Object> missionId, Boolean upcoming, String launchYear, Integer launchDateUnix, String launchDateUtc, String launchDateLocal, Boolean isTentative, String tentativeMaxPrecision, Boolean tbd, Integer launchWindow, Rocket rocket, List<Object> ships, Telemetry telemetry, LaunchSite launchSite, Boolean launchSuccess, LaunchFailureDetails launchFailureDetails, Links links, String details, String staticFireDateUtc, Integer staticFireDateUnix, Timeline timeline, Object crew) {
        this.flightNumber = flightNumber;
        this.missionName = missionName;
        this.missionId = missionId;
        this.upcoming = upcoming;
        this.launchYear = launchYear;
        this.launchDateUnix = launchDateUnix;
        this.launchDateUtc = launchDateUtc;
        this.launchDateLocal = launchDateLocal;
        this.isTentative = isTentative;
        this.tentativeMaxPrecision = tentativeMaxPrecision;
        this.tbd = tbd;
        this.launchWindow = launchWindow;
        this.rocket = rocket;
        this.ships = ships;
        this.telemetry = telemetry;
        this.launchSite = launchSite;
        this.launchSuccess = launchSuccess;
        this.launchFailureDetails = launchFailureDetails;
        this.links = links;
        this.details = details;
        this.staticFireDateUtc = staticFireDateUtc;
        this.staticFireDateUnix = staticFireDateUnix;
        this.timeline = timeline;
        this.crew = crew;
    }

    public Boolean getTentative() {
        return isTentative;
    }

    public void setTentative(Boolean tentative) {
        isTentative = tentative;
    }

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }

    protected FlightItemDetails(Parcel in) {
        if (in.readByte() == 0) {
            flightNumber = null;
        } else {
            flightNumber = in.readInt();
        }
        missionName = in.readString();
        byte tmpUpcoming = in.readByte();
        upcoming = tmpUpcoming == 0 ? null : tmpUpcoming == 1;
        launchYear = in.readString();
        if (in.readByte() == 0) {
            launchDateUnix = null;
        } else {
            launchDateUnix = in.readInt();
        }
        launchDateUtc = in.readString();
        launchDateLocal = in.readString();
        byte tmpIsTentative = in.readByte();
        isTentative = tmpIsTentative == 0 ? null : tmpIsTentative == 1;
        tentativeMaxPrecision = in.readString();
        byte tmpTbd = in.readByte();
        tbd = tmpTbd == 0 ? null : tmpTbd == 1;
        if (in.readByte() == 0) {
            launchWindow = null;
        } else {
            launchWindow = in.readInt();
        }
        byte tmpLaunchSuccess = in.readByte();
        launchSuccess = tmpLaunchSuccess == 0 ? null : tmpLaunchSuccess == 1;
        details = in.readString();
        staticFireDateUtc = in.readString();
        if (in.readByte() == 0) {
            staticFireDateUnix = null;
        } else {
            staticFireDateUnix = in.readInt();
        }
    }



    public Integer getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(Integer flightNumber) {
            this.flightNumber = flightNumber;
        }

        public String getMissionName() {
            return missionName;
        }

        public void setMissionName(String missionName) {
            this.missionName = missionName;
        }

        public List<Object> getMissionId() {
            return missionId;
        }

        public void setMissionId(List<Object> missionId) {
            this.missionId = missionId;
        }

        public Boolean getUpcoming() {
            return upcoming;
        }

        public void setUpcoming(Boolean upcoming) {
            this.upcoming = upcoming;
        }

        public String getLaunchYear() {
            return launchYear;
        }

        public void setLaunchYear(String launchYear) {
            this.launchYear = launchYear;
        }

        public Integer getLaunchDateUnix() {
            return launchDateUnix;
        }

        public void setLaunchDateUnix(Integer launchDateUnix) {
            this.launchDateUnix = launchDateUnix;
        }

        public String getLaunchDateUtc() {
            return launchDateUtc;
        }

        public void setLaunchDateUtc(String launchDateUtc) {
            this.launchDateUtc = launchDateUtc;
        }

        public String getLaunchDateLocal() {
            return launchDateLocal;
        }

        public void setLaunchDateLocal(String launchDateLocal) {
            this.launchDateLocal = launchDateLocal;
        }

        public Boolean getIsTentative() {
            return isTentative;
        }

        public void setIsTentative(Boolean isTentative) {
            this.isTentative = isTentative;
        }

        public String getTentativeMaxPrecision() {
            return tentativeMaxPrecision;
        }

        public void setTentativeMaxPrecision(String tentativeMaxPrecision) {
            this.tentativeMaxPrecision = tentativeMaxPrecision;
        }

        public Boolean getTbd() {
            return tbd;
        }

        public void setTbd(Boolean tbd) {
            this.tbd = tbd;
        }

        public Integer getLaunchWindow() {
            return launchWindow;
        }

        public void setLaunchWindow(Integer launchWindow) {
            this.launchWindow = launchWindow;
        }

        public Rocket getRocket() {
            return rocket;
        }

        public void setRocket(Rocket rocket) {
            this.rocket = rocket;
        }

        public List<Object> getShips() {
            return ships;
        }

        public void setShips(List<Object>  ships) {
            this.ships = ships;
        }

        public Telemetry getTelemetry() {
            return telemetry;
        }

        public void setTelemetry(Telemetry telemetry) {
            this.telemetry = telemetry;
        }

        public LaunchSite getLaunchSite() {
            return launchSite;
        }

        public void setLaunchSite(LaunchSite launchSite) {
            this.launchSite = launchSite;
        }

        public Boolean getLaunchSuccess() {
            return launchSuccess;
        }

        public void setLaunchSuccess(Boolean launchSuccess) {
        if (launchSuccess != null ) {
            this.launchSuccess = launchSuccess;
        }
        }

        public LaunchFailureDetails getLaunchFailureDetails() {
            return launchFailureDetails;
        }

        public void setLaunchFailureDetails(LaunchFailureDetails launchFailureDetails) {
            this.launchFailureDetails = launchFailureDetails;
        }

        public Links getLinks() {
            return links;
        }

        public void setLinks(Links links) {
            this.links = links;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getStaticFireDateUtc() {
            return staticFireDateUtc;
        }

        public void setStaticFireDateUtc(String staticFireDateUtc) {
            this.staticFireDateUtc = staticFireDateUtc;
        }

        public Integer getStaticFireDateUnix() {
            return staticFireDateUnix;
        }

        public void setStaticFireDateUnix(Integer staticFireDateUnix) {
            this.staticFireDateUnix = staticFireDateUnix;
        }

        public Timeline getTimeline() {
            return timeline;
        }

        public void setTimeline(Timeline timeline) {
            this.timeline = timeline;
        }

        public Object getCrew() {
            return crew;
        }

        public void setCrew(Object crew) {
            this.crew = crew;
        }


}

