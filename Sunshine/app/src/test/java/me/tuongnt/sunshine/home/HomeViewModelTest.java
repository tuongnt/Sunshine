package me.tuongnt.sunshine.home;

import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void setup() {
        mWeatherService = mock(WeatherService.class);
        mHomeViewModel = new HomeViewModel(mWeatherService);
    }

    @Test
    public void testGetWeatherSuccess(){
        Weather weather = new Weather(24, 24, 24, "Clouds", 92);
        when(mWeatherService.getWeatherLocation(21.03, 105.85))
                .thenReturn(Observable.just(weather));

        mHomeViewModel.setLatLocation(21.03);
        mHomeViewModel.setLongLocation(105.85);

        TestSubscriber<Weather> getWeatherSubscriber = new TestSubscriber<>();
        mHomeViewModel.onGetWeatherSuccess().subscribe(getWeatherSubscriber);
        mHomeViewModel.getWeather();
        getWeatherSubscriber.assertValue(weather);
    }
}
