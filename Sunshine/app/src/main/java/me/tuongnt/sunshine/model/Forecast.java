package me.tuongnt.sunshine.model;

import java.util.List;

/**
 * Created by tuong.nguyen on 5/20/16.
 */
public class Forecast {
    String mCityName;
    List<Weather> mWeathers;

    public Forecast(String cityName, List<Weather> weathers) {
        mCityName = cityName;
        mWeathers = weathers;
    }

    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String cityName) {
        mCityName = cityName;
    }

    public List<Weather> getWeathers() {
        return mWeathers;
    }

    public void setWeathers(List<Weather> weathers) {
        mWeathers = weathers;
    }
}
