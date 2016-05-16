package me.tuongnt.sunshine.ui.home.view;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.Date;

import butterknife.Bind;
import me.tuongnt.sunshine.R;
import me.tuongnt.sunshine.app.component.AppComponent;
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
                .subscribe(weather -> {
                    currentTemperatureField.setText(String.format("%.2f", weather.getTemp()));
                    Log.i(TAG, weather.toString());
                }));

        mSubscriptions.add(mViewModel.OnGetWeatherFailed()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(message ->{
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


    private void setWeatherIcon(int actualId, long sunrise, long sunset) {
        int id = actualId / 100;
        String icon = "";
        if (actualId == 800) {
            long currentTime = new Date().getTime();
            if (currentTime >= sunrise && currentTime < sunset) {
                icon = getActivity().getString(R.string.weather_sunny);
            } else {
                icon = getActivity().getString(R.string.weather_clear_night);
            }
        } else {
            switch (id) {
                case 2:
                    icon = getActivity().getString(R.string.weather_thunder);
                    break;
                case 3:
                    icon = getActivity().getString(R.string.weather_drizzle);
                    break;
                case 7:
                    icon = getActivity().getString(R.string.weather_foggy);
                    break;
                case 8:
                    icon = getActivity().getString(R.string.weather_cloudy);
                    break;
                case 6:
                    icon = getActivity().getString(R.string.weather_snowy);
                    break;
                case 5:
                    icon = getActivity().getString(R.string.weather_rainy);
                    break;
            }
        }
        weatherIcon.setText(icon);
    }
}
