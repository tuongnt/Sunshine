package me.tuongnt.sunshine.home;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import me.tuongnt.sunshine.model.Forecast;
import me.tuongnt.sunshine.model.Weather;
import me.tuongnt.sunshine.service.WeatherService;
import me.tuongnt.sunshine.ui.home.viewmodel.HomeViewModel;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by TuongNguyen on 5/11/16.
 */
public class HomeViewModelTest {
    WeatherService mWeatherService;
    HomeViewModel mHomeViewModel;
    @Mock
    private ArrayList<Weather> mockWeathers;

    @Before
    public void setup() {
        mWeatherService = mock(WeatherService.class);
        mHomeViewModel = new HomeViewModel(mWeatherService);
    }

    @Test
    public void testGetWeatherSuccess(){
        Forecast forecast = new Forecast("HCM", mockWeathers);

        when(mWeatherService.getWeatherLocation("ho chi minh,vn"))
                .thenReturn(Observable.just(forecast));

        mHomeViewModel.setCity("ho chi minh,vn");

        TestSubscriber<Forecast> getWeatherSubscriber = new TestSubscriber<>();
        mHomeViewModel.onGetWeatherSuccess().subscribe(getWeatherSubscriber);
        mHomeViewModel.getWeather();
        getWeatherSubscriber.assertValue(forecast);
    }
}
