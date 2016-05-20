
package me.tuongnt.sunshine.data.entity;

import com.google.gson.annotations.SerializedName;

public class Coord {
    @SerializedName("lon")
    private Double lon;

    @SerializedName("lat")
    private Double lat;

    /**
     * @return The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * @param lon The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * @return The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @param lat The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

}
