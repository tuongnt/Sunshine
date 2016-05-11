
package me.tuongnt.sunshine.data.entity;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Clouds {

    @SerializedName("all")
    @Expose
    private Long all;

    /**
     * 
     * @return
     *     The all
     */
    public Long getAll() {
        return all;
    }

    /**
     * 
     * @param all
     *     The all
     */
    public void setAll(Long all) {
        this.all = all;
    }

}
