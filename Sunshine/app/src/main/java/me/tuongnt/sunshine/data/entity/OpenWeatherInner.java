
package me.tuongnt.sunshine.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class OpenWeatherInner {
    @SerializedName("dt")
    private long dt;

    @SerializedName("temp")
    private Temp temp;

    @SerializedName("pressure")
    private float pressure;

    @SerializedName("humidity")
    private float humidity;

    @SerializedName("weather")
    private List<OpenWeather> mOpenWeather = new ArrayList<OpenWeather>();

    @SerializedName("speed")
    private float speed;

    @SerializedName("deg")
    private float deg;

    @SerializedName("clouds")
    private float clouds;

    @SerializedName("rain")
    private float rain;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public List<OpenWeather> getOpenWeather() {
        return mOpenWeather;
    }

    public void setOpenWeather(List<OpenWeather> openWeather) {
        mOpenWeather = openWeather;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

    public float getClouds() {
        return clouds;
    }

    public void setClouds(float clouds) {
        this.clouds = clouds;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }
}
