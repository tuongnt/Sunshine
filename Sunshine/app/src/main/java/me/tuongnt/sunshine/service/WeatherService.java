package me.tuongnt.sunshine.service;

import me.tuongnt.sunshine.model.Weather;
import rx.Observable;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public interface WeatherService {
    Observable<Weather> getWeatherLocation(double lat, double lon);
}
