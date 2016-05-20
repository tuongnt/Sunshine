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

    @GET("forecast?units=metric")
    Observable<WeatherResponse> getWeather(@Query("q") String city);
}
