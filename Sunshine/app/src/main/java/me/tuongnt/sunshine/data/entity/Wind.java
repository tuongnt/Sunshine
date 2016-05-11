
package me.tuongnt.sunshine.data.entity;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Wind {

    @SerializedName("speed")
    @Expose
    private float speed;
    @SerializedName("deg")
    @Expose
    private float deg;

    /**
     * 
     * @return
     *     The speed
     */
    public Float getSpeed() {
        return speed;
    }

    /**
     * 
     * @param speed
     *     The speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * 
     * @return
     *     The deg
     */
    public float getDeg() {
        return deg;
    }

    /**
     * 
     * @param deg
     *     The deg
     */
    public void setDeg(Float deg) {
        this.deg = deg;
    }

}
