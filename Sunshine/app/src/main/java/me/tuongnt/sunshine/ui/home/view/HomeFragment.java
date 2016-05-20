package me.tuongnt.sunshine.ui.home.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.Locale;

import butterknife.Bind;
import me.tuongnt.sunshine.R;
import me.tuongnt.sunshine.app.component.AppComponent;
import me.tuongnt.sunshine.model.Weather;
import me.tuongnt.sunshine.ui.SunshineError;
import me.tuongnt.sunshine.ui.common.BaseFragment;
import me.tuongnt.sunshine.ui.home.viewmodel.HomeViewModel;
import me.tuongnt.sunshine.ui.view.ErrorView;
import me.tuongnt.sunshine.utils.NetworkManager;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public class HomeFragment extends BaseFragment<HomeViewModel> {
    private static final String TAG = HomeFragment.class.getSimpleName();

    @Bind(R.id.content_switcher)
    ViewSwitcher mViewSwitcher;

    @Bind(R.id.error_view)
    ErrorView mErrorView;


    @Bind(R.id.city_field)
    TextView cityField;

    @Bind(R.id.updated_field)
    TextView updatedField;

    @Bind(R.id.details_field)
    TextView detailsField;

    @Bind(R.id.current_temperature_field)
    TextView currentTemperatureField;

    @Bind(R.id.weather_icon)
    TextView weatherIcon;

    Typeface mWeatherFont;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weathericons-regular-webfont.ttf");
    }

    @Override
    protected int getFragmentLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void inject(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    protected void bindViewModel() {
        final NetworkManager networkManager = new NetworkManager(getContext());
        weatherIcon.setTypeface(mWeatherFont);
        mSubscriptions.add(networkManager
                .connection()
                .doOnNext(this::handleConnectionStateChanged)
                .filter(connected -> connected)
                .subscribe(connection -> {
                    mViewModel.setCity("ho chi minh,vn");
                    mViewModel.getWeather();
                })
        );

        mSubscriptions.add(mViewModel.onGetWeatherSuccess()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .filter(result -> result != null)
                .subscribe(forecast -> {
                    cityField.setText(forecast.getCityName());

                    Weather weather = forecast.getWeathers().get(0);
                    currentTemperatureField.setText(String.format("%.2f", weather.getTemp())+ " ℃");
                    weatherIcon.setText(weather.getResource());
                    detailsField.setText(
                            weather.getDescription().toUpperCase(Locale.US) +
                                    "\n" + "Humidity: " + weather.getHumidity() + "%");
                }));

        mSubscriptions.add(mViewModel.OnGetWeatherFailed()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(message -> {
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                }));
    }

    private void handleConnectionStateChanged(boolean connected) {
        if (connected) {
            mViewSwitcher.setDisplayedChild(0);
        } else {
            mErrorView.showError(SunshineError.NETWORK_ERROR);
            mViewSwitcher.setDisplayedChild(1);
        }
    }

}
