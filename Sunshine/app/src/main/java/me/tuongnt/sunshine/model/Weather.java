package me.tuongnt.sunshine.model;

/**
 * Created by TuongNguyen on 5/11/16.
 */
public class Weather {
    private float mTemp;
    private float mTempMin;
    private float mTempMax;
    private String mWeatherCondition;
    private int mHumidity;

    public Weather() {
    }

    public Weather(float temp, float tempMin, float tempMax, String weatherCondition, int humidity) {
        mTemp = temp;
        mTempMin = tempMin;
        mTempMax = tempMax;
        mWeatherCondition = weatherCondition;
        mHumidity = humidity;
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

    public String getWeatherCondition() {
        return mWeatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        mWeatherCondition = weatherCondition;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public void setHumidity(int humidity) {
        mHumidity = humidity;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "mTemp=" + mTemp +
                ", mTempMin=" + mTempMin +
                ", mTempMax=" + mTempMax +
                ", mWeatherCondition='" + mWeatherCondition + '\'' +
                ", mHumidity=" + mHumidity +
                '}';
    }
}
