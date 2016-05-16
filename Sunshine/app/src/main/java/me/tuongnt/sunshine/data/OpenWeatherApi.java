package me.tuongnt.sunshine.data;

import me.tuongnt.sunshine.data.entity.WeatherResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by TuongNguyen on 5/11/16.
 */
public interface OpenWeatherApi {

    @GET("forecast/daily?appid=d30d7e3341272983cfb2a378c00c15a1")
    Observable<WeatherResponse> getWeather(@Query("q") String city);
}
