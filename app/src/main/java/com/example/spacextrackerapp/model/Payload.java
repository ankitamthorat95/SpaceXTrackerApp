package com.example.spacextrackerapp.model;

import androidx.room.Entity;
import androidx.room.Index;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Payload implements Serializable {

    @SerializedName("payload_id")
    @Expose
    public String payloadId;
    @SerializedName("norad_id")
    @Expose
    public List<Object> noradId;
    @SerializedName("reused")
    @Expose
    public Boolean reused;
    @SerializedName("customers")
    @Expose
    public List<String> customers;
    @SerializedName("nationality")
    @Expose
    public String nationality;
    @SerializedName("manufacturer")
    @Expose
    public String manufacturer;
    @SerializedName("payload_type")
    @Expose
    public String payloadType;
    @SerializedName("payload_mass_kg")
    @Expose
    public double payloadMassKg;
    @SerializedName("payload_mass_lbs")
    @Expose
    public double payloadMassLbs;
    @SerializedName("orbit")
    @Expose
    public String orbit;
    @SerializedName("orbit_params")
    @Expose
    public OrbitParams orbitParams;

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public List<Object> getNoradId() {
        return noradId;
    }

    public void setNoradId(List<Object> noradId) {
        this.noradId = noradId;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    public double getPayloadMassKg() {
        return payloadMassKg;
    }

    public void setPayloadMassKg(double payloadMassKg) {
        this.payloadMassKg = payloadMassKg;
    }

    public double getPayloadMassLbs() {
        return payloadMassLbs;
    }

    public void setPayloadMassLbs(double payloadMassLbs) {
        this.payloadMassLbs = payloadMassLbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public OrbitParams getOrbitParams() {
        return orbitParams;
    }

    public void setOrbitParams(OrbitParams orbitParams) {
        this.orbitParams = orbitParams;
    }

}
