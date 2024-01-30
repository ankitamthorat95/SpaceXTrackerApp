package com.example.spacextrackerapp.model;

import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Index;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Timeline implements Serializable {

    @SerializedName("webcast_liftoff")
    @Expose
    private Integer webcastLiftoff;

    public Integer getWebcastLiftoff() {
        return webcastLiftoff;
    }

    public void setWebcastLiftoff(Integer webcastLiftoff) {
        this.webcastLiftoff = webcastLiftoff;
    }

}
