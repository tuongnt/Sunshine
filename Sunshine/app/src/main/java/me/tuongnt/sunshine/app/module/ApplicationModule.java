package me.tuongnt.sunshine.app.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.tuongnt.sunshine.service.WeatherService;
import me.tuongnt.sunshine.service.impl.WeatherServiceImpl;
import me.tuongnt.sunshine.ui.common.Router;

/**
 * Created by TuongNguyen on 5/10/16.
 */
@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Singleton
    @Provides
    Application providesApplication() {
        return mApplication;
    }

    @Singleton
    @Provides
    Router providesRouter() {
        return new Router();
    }

    @Singleton
    @Provides
    Context providesContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    public WeatherService providesAuthenticationService(WeatherServiceImpl weatherService) {
        return weatherService;
    }
}
