package me.tuongnt.sunshine.data.impl;

import javax.inject.Inject;

import me.tuongnt.sunshine.data.OpenWeatherApi;
import me.tuongnt.sunshine.data.WeatherRepository;
import me.tuongnt.sunshine.data.mapper.WeatherMapper;
import me.tuongnt.sunshine.model.Forecast;
import rx.Observable;

/**
 * Created by TuongNguyen on 5/11/16.
 */
public class WeatherRepositoryImpl implements WeatherRepository {
    private OpenWeatherApi mOpenWeatherApi;
    private WeatherMapper mWeatherMapper;

    @Inject
    public WeatherRepositoryImpl(OpenWeatherApi openWeatherApi, WeatherMapper weatherMapper) {
        mOpenWeatherApi = openWeatherApi;
        mWeatherMapper = weatherMapper;
    }

    @Override
    public Observable<Forecast> getWeather(String city) {
        return mOpenWeatherApi.getWeather(city)
                .map(weatherResponse -> mWeatherMapper.transform(weatherResponse));
    }
}
