package me.tuongnt.sunshine.model;

/**
 * Created by TuongNguyen on 5/11/16.
 */
public class Weather {
    private float mTemp;
    private float mTempMin;
    private float mTempMax;
    private String mWeatherMain;
    private String mDescription;
    private int mResource;
    private int mHumidity;

    public Weather() {
    }

    public Weather(float temp, float tempMin, float tempMax) {
        mTemp = temp;
        mTempMin = tempMin;
        mTempMax = tempMax;
    }

    public float getTemp() {
        return mTemp;
    }

    public void setTemp(float temp) {
        mTemp = temp;
    }

    public float getTempMin() {
        return mTempMin;
    }

    public void setTempMin(float tempMin) {
        mTempMin = tempMin;
    }

    public float getTempMax() {
        return mTempMax;
    }

    public void setTempMax(float tempMax) {
        mTempMax = tempMax;
    }

    public String getWeatherMain() {
        return mWeatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        mWeatherMain = weatherMain;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getResource() {
        return mResource;
    }

    public void setResource(int resource) {
        mResource = resource;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public void setHumidity(int humidity) {
        mHumidity = humidity;
    }
}
