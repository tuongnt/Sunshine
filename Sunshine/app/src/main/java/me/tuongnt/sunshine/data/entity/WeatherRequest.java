package me.tuongnt.sunshine.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TuongNguyen on 5/11/16.
 */
public class WeatherRequest {
    @SerializedName("lat")
    private double latLocation;

    @SerializedName("lon")
    private double longLocation;

    @SerializedName("units")
    private String mTemperature;

    public double getLatLocation() {
        return latLocation;
    }

    public void setLatLocation(double latLocation) {
        this.latLocation = latLocation;
    }

    public double getLongLocation() {
        return longLocation;
    }

    public void setLongLocation(double longLocation) {
        this.longLocation = longLocation;
    }

    public String getTemperature() {
        return mTemperature;
    }

    public void setTemperature(String temperature) {
        mTemperature = temperature;
    }
}
