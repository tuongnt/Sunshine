package me.tuongnt.sunshine.ui.home.viewmodel;

import javax.inject.Inject;

import me.tuongnt.sunshine.model.Weather;
import me.tuongnt.sunshine.service.WeatherService;
import me.tuongnt.sunshine.ui.common.BaseViewModel;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public class HomeViewModel extends BaseViewModel {
    private BehaviorSubject<String> mCity = BehaviorSubject.create();
    private BehaviorSubject<Void> mWeather = BehaviorSubject.create();
    private Observable<Weather> OnGetWeatherSuccess = Observable.empty();
    private PublishSubject<String> OnGetWeatherFailed = PublishSubject.create();

    @Inject
    public HomeViewModel(WeatherService weatherService) {
        OnGetWeatherSuccess = mWeather
                .doOnError(error -> {
                    OnGetWeatherFailed.onNext(error.getMessage());
                })
                .onErrorResumeNext(Observable.empty())
                .flatMap(trigger -> weatherService.getWeatherLocation(mCity.getValue()));
    }

    public Observable<Weather> onGetWeatherSuccess() {
        return OnGetWeatherSuccess;
    }

    public PublishSubject<String> OnGetWeatherFailed() {
        return OnGetWeatherFailed;
    }

    public void getWeather() {
        mWeather.onNext(null);
    }

    public void setCity(String city) {
        mCity.onNext(city);
    }
}
