package com.example.spacextrackerapp.model;

import androidx.room.Entity;
import androidx.room.Index;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class SecondStage implements Serializable {
    @SerializedName("flight_number")
    @Expose
    public Integer flightNumber;

    @SerializedName("block")
    @Expose
    private Integer block;
    @SerializedName("payloads")
    @Expose
    private List<Payload> payloads;

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }

}
