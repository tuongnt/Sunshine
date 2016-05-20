package me.tuongnt.sunshine.data.mapper;

import java.util.ArrayList;
import java.util.List;

import me.tuongnt.sunshine.R;
import me.tuongnt.sunshine.data.entity.OpenWeather;
import me.tuongnt.sunshine.data.entity.OpenWeatherInner;
import me.tuongnt.sunshine.data.entity.WeatherResponse;
import me.tuongnt.sunshine.model.Forecast;
import me.tuongnt.sunshine.model.Weather;

/**
 * Created by tuong.nguyen on 5/17/16.
 */
public class WeatherMapper extends BaseTransform<WeatherResponse, Forecast> {

    @Override
    public Forecast transform(WeatherResponse weatherResponse) {
        List<Weather> weathers = new ArrayList<>();

        for (OpenWeatherInner openWeatherInner : weatherResponse.getOpenWeatherInner()) {
            Weather weather = new Weather(openWeatherInner.getMain().getTemp(),
                    openWeatherInner.getMain().getTempMin(),
                    openWeatherInner.getMain().getTempMax());
            weather.setHumidity(openWeatherInner.getMain().getHumidity());

            List<OpenWeather> openWeathers = openWeatherInner.getOpenWeather();
            if (openWeathers != null && openWeatherInner.getOpenWeather().size() > 0) {
                weather.setWeatherMain(openWeathers.get(0).getMain());
                weather.setResource(getWeatherIcon(openWeathers.get(0).getId()));
                weather.setDescription(openWeathers.get(0).getDescription());
            }

            weathers.add(weather);
        }
        return new Forecast(weatherResponse.getCity().getName() + ", " + weatherResponse.getCity().getCountry(), weathers);
    }

    private int getWeatherIcon(int actualId) {
        int id = actualId / 100;
        int icon = -1;
        switch (id) {
            case 2:
                icon = R.string.weather_thunder;
                break;
            case 3:
                icon = R.string.weather_drizzle;
                break;
            case 7:
                icon = R.string.weather_foggy;
                break;
            case 8:
                icon = R.string.weather_cloudy;
                break;
            case 6:
                icon = R.string.weather_snowy;
                break;
            case 5:
                icon = R.string.weather_rainy;
                break;
        }

        return icon;
    }


}
