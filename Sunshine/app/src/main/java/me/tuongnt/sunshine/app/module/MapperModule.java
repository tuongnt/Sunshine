package me.tuongnt.sunshine.app.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.tuongnt.sunshine.data.mapper.WeatherMapper;

/**
 * Created by tuong.nguyen on 5/20/16.
 */
@Module
public class MapperModule {

    @Provides
    @Singleton
    public WeatherMapper providesWeatherMapper(){
        return new WeatherMapper();
    }
}
