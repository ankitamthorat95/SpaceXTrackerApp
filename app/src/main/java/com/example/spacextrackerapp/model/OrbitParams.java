package com.example.spacextrackerapp.model;

import androidx.room.Entity;
import androidx.room.Index;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class OrbitParams implements Serializable {

    @SerializedName("reference_system")
    @Expose
    public String referenceSystem;
    @SerializedName("regime")
    @Expose
    public String regime;
    @SerializedName("longitude")
    @Expose
    public Object longitude;
    @SerializedName("semi_major_axis_km")
    @Expose
    public Object semiMajorAxisKm;
    @SerializedName("eccentricity")
    @Expose
    public Object eccentricity;
    @SerializedName("periapsis_km")
    @Expose
    public double periapsisKm;
    @SerializedName("apoapsis_km")
    @Expose
    public double apoapsisKm;
    @SerializedName("inclination_deg")
    @Expose
    public double inclinationDeg;
    @SerializedName("period_min")
    @Expose
    public Object periodMin;
    @SerializedName("lifespan_years")
    @Expose
    public Object lifespanYears;
    @SerializedName("epoch")
    @Expose
    public Object epoch;
    @SerializedName("mean_motion")
    @Expose
    public Object meanMotion;
    @SerializedName("raan")
    @Expose
    public Object raan;
    @SerializedName("arg_of_pericenter")
    @Expose
    public Object argOfPericenter;
    @SerializedName("mean_anomaly")
    @Expose
    public Object meanAnomaly;

    public String getReferenceSystem() {
        return referenceSystem;
    }

    public void setReferenceSystem(String referenceSystem) {
        this.referenceSystem = referenceSystem;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getSemiMajorAxisKm() {
        return semiMajorAxisKm;
    }

    public void setSemiMajorAxisKm(Object semiMajorAxisKm) {
        this.semiMajorAxisKm = semiMajorAxisKm;
    }

    public Object getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Object eccentricity) {
        this.eccentricity = eccentricity;
    }

    public double getPeriapsisKm() {
        return periapsisKm;
    }

    public void setPeriapsisKm(double periapsisKm) {
        this.periapsisKm = periapsisKm;
    }

    public double getApoapsisKm() {
        return apoapsisKm;
    }

    public void setApoapsisKm(double apoapsisKm) {
        this.apoapsisKm = apoapsisKm;
    }

    public double getInclinationDeg() {
        return inclinationDeg;
    }

    public void setInclinationDeg(double inclinationDeg) {
        this.inclinationDeg = inclinationDeg;
    }

    public Object getPeriodMin() {
        return periodMin;
    }

    public void setPeriodMin(Object periodMin) {
        this.periodMin = periodMin;
    }

    public Object getLifespanYears() {
        return lifespanYears;
    }

    public void setLifespanYears(Object lifespanYears) {
        this.lifespanYears = lifespanYears;
    }

    public Object getEpoch() {
        return epoch;
    }

    public void setEpoch(Object epoch) {
        this.epoch = epoch;
    }

    public Object getMeanMotion() {
        return meanMotion;
    }

    public void setMeanMotion(Object meanMotion) {
        this.meanMotion = meanMotion;
    }

    public Object getRaan() {
        return raan;
    }

    public void setRaan(Object raan) {
        this.raan = raan;
    }

    public Object getArgOfPericenter() {
        return argOfPericenter;
    }

    public void setArgOfPericenter(Object argOfPericenter) {
        this.argOfPericenter = argOfPericenter;
    }

    public Object getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(Object meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }

}
