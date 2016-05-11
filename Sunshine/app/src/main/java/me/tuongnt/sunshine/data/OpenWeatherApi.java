package me.tuongnt.sunshine.data;

import me.tuongnt.sunshine.data.entity.WeatherResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by TuongNguyen on 5/11/16.
 */
public interface OpenWeatherApi {

    @GET("weather?lat=21.03&lon=105.85&appid=d30d7e3341272983cfb2a378c00c15a1")
    Observable<WeatherResponse> getWeather();
}
