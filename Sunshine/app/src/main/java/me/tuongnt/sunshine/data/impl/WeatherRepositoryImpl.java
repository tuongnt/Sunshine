package me.tuongnt.sunshine.data.impl;

import javax.inject.Inject;

import me.tuongnt.sunshine.data.OpenWeatherApi;
import me.tuongnt.sunshine.data.WeatherRepository;
import me.tuongnt.sunshine.model.Weather;
import rx.Observable;

/**
 * Created by TuongNguyen on 5/11/16.
 */
public class WeatherRepositoryImpl implements WeatherRepository{
    private OpenWeatherApi mOpenWeatherApi;

    @Inject
    public WeatherRepositoryImpl(OpenWeatherApi openWeatherApi) {
        mOpenWeatherApi = openWeatherApi;
    }

    @Override
    public Observable<Weather> getWeather(double lat, double lon) {
        return mOpenWeatherApi.getWeather()
                .map(weatherResponse -> new Weather(weatherResponse.getMain().getTemp(),
                        weatherResponse.getMain().getTempMin(),
                        weatherResponse.getMain().getTempMax(),
                        weatherResponse.getOpenWeather().get(0).getMain(),
                        weatherResponse.getMain().getHumidity()));
    }
}
