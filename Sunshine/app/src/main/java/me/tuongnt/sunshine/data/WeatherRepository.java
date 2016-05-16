package me.tuongnt.sunshine.data;

import me.tuongnt.sunshine.model.Weather;
import rx.Observable;

/**
 * Created by TuongNguyen on 5/11/16.
 */
public interface WeatherRepository {
    Observable<Weather> getWeather(String city);
}
