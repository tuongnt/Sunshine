package me.tuongnt.sunshine.app.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.tuongnt.sunshine.data.OpenWeatherApi;
import me.tuongnt.sunshine.data.WeatherRepository;
import me.tuongnt.sunshine.data.impl.WeatherRepositoryImpl;
import retrofit2.Retrofit;

/**
 * Created by TuongNguyen on 5/11/16.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public OpenWeatherApi providesTokenApi(Retrofit retrofit) {
        return retrofit.create(OpenWeatherApi.class);
    }

    @Provides
    @Singleton
    public WeatherRepository provideUserRepository(WeatherRepositoryImpl weatherRepository) {
        return weatherRepository;
    }
}
