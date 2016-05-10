package me.tuongnt.sunshine.service.impl;

import javax.inject.Inject;

import me.tuongnt.sunshine.model.Weather;
import me.tuongnt.sunshine.service.WeatherService;
import rx.Observable;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public class WeatherServiceImpl implements WeatherService{

    @Inject
    public WeatherServiceImpl() {
    }

    @Override
    public Observable<Weather> getWeatherLocation(double lat, double lon) {
        return null;
    }
}
