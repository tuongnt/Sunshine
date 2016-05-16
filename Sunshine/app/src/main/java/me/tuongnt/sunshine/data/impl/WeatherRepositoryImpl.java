package me.tuongnt.sunshine.data.impl;

import javax.inject.Inject;

import me.tuongnt.sunshine.data.OpenWeatherApi;
import me.tuongnt.sunshine.data.WeatherRepository;
import me.tuongnt.sunshine.model.Weather;
import rx.Observable;

/**
 * Created by TuongNguyen on 5/11/16.
 */
public class WeatherRepositoryImpl implements WeatherRepository {
    private OpenWeatherApi mOpenWeatherApi;

    @Inject
    public WeatherRepositoryImpl(OpenWeatherApi openWeatherApi) {
        mOpenWeatherApi = openWeatherApi;
    }

    @Override
    public Observable<Weather> getWeather(String city) {
        return mOpenWeatherApi.getWeather(city)
                .map(weatherResponse -> new Weather(11,
                        12,
                        13,
                        "Rain",
                        85));
    }
}
