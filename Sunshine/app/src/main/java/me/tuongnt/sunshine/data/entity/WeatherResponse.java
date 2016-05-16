
package me.tuongnt.sunshine.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WeatherResponse {
    @SerializedName("city")
    private City city;

    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private double message;

    @SerializedName("cnt")
    private Long cnt;

    @SerializedName("list")
    private List<OpenWeatherInner> mOpenWeatherInner = new ArrayList<OpenWeatherInner>();

    /**
     * @return The city
     */
    public City getCity() {
        return city;
    }

    /**
     * @param city The city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * @return The cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod The cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return The message
     */
    public double getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(double message) {
        this.message = message;
    }

    /**
     * @return The cnt
     */
    public Long getCnt() {
        return cnt;
    }

    /**
     * @param cnt The cnt
     */
    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    /**
     * @return The mOpenWeatherInner
     */
    public java.util.List<OpenWeatherInner> getOpenWeatherInner() {
        return mOpenWeatherInner;
    }

    /**
     * @param openWeatherInner The mOpenWeatherInner
     */
    public void setOpenWeatherInner(java.util.List<OpenWeatherInner> openWeatherInner) {
        this.mOpenWeatherInner = openWeatherInner;
    }

}
