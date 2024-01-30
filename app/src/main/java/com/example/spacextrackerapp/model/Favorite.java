package com.example.spacextrackerapp.model;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName="favoritelist",indices = @Index(value = {"flightNumber"},unique = true))

public class Favorite {
    @PrimaryKey
    private int id;

    public boolean isFavourite;

    @SerializedName("flight_number")
    @Expose
    public Integer flightNumber;

    public Favorite(Integer flightNumber, boolean isFavourite) {
        this.flightNumber = flightNumber;
        this.isFavourite = isFavourite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }
}
