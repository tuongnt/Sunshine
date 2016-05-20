package me.tuongnt.sunshine.service.impl;

import javax.inject.Inject;

import me.tuongnt.sunshine.data.WeatherRepository;
import me.tuongnt.sunshine.model.Forecast;
import me.tuongnt.sunshine.model.Weather;
import me.tuongnt.sunshine.service.WeatherService;
import rx.Observable;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public class WeatherServiceImpl implements WeatherService {
    private WeatherRepository mWeatherRepository;

    @Inject
    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        mWeatherRepository = weatherRepository;
    }

    @Override
    public Observable<Forecast> getWeatherLocation(String city) {
        return mWeatherRepository.getWeather(city);
    }
}
