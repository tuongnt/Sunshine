package me.tuongnt.sunshine.app;

import android.app.Application;

import me.tuongnt.sunshine.R;
import me.tuongnt.sunshine.app.component.AppComponent;
import me.tuongnt.sunshine.app.component.DaggerAppComponent;
import me.tuongnt.sunshine.app.module.ApplicationModule;
import me.tuongnt.sunshine.app.module.NetworkModule;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public class SunshineApp extends Application{
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        String serverUrl = getResources().getString(R.string.open_weather_url);

        appComponent = DaggerAppComponent.builder()
                .networkModule(new NetworkModule(serverUrl))
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
