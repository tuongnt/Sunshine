
package me.tuongnt.sunshine.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Sys {

    @SerializedName("message")
    @Expose
    private float message;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("sunrise")
    @Expose
    private long sunrise;
    @SerializedName("sunset")
    @Expose
    private long
            sunset;

    /**
     * @return The message
     */
    public float getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(float message) {
        this.message = message;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The sunrise
     */
    public long getSunrise() {
        return sunrise;
    }

    /**
     * @param sunrise The sunrise
     */
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * @return The sunset
     */
    public long getSunset() {
        return sunset;
    }

    /**
     * @param sunset The sunset
     */
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

}
