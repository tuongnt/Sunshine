package me.tuongnt.sunshine.ui.home.viewmodel;

import javax.inject.Inject;

import me.tuongnt.sunshine.model.Weather;
import me.tuongnt.sunshine.service.WeatherService;
import me.tuongnt.sunshine.ui.common.BaseViewModel;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public class HomeViewModel extends BaseViewModel {
    private double mLatLocation;
    private double mLongLocation;
    private BehaviorSubject<Void> mWeather = BehaviorSubject.create();
    private Observable<Weather> OnGetWeatherSuccess = Observable.empty();

    @Inject
    public HomeViewModel(WeatherService weatherService) {

        OnGetWeatherSuccess = mWeather
                .flatMap(trigger -> weatherService.getWeatherLocation(mLatLocation, mLongLocation));
    }

    public Observable<Weather> onGetWeatherSuccess() {
        return OnGetWeatherSuccess;
    }

    public void getWeather() {
        mWeather.onNext(null);
    }

    public void setLatLocation(double latLocation) {
        mLatLocation = latLocation;
    }

    public void setLongLocation(double longLocation) {
        mLongLocation = longLocation;
    }
}
