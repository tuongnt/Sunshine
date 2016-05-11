package me.tuongnt.sunshine.ui.home.view;

import android.util.Log;

import me.tuongnt.sunshine.R;
import me.tuongnt.sunshine.app.component.AppComponent;
import me.tuongnt.sunshine.ui.common.BaseFragment;
import me.tuongnt.sunshine.ui.home.viewmodel.HomeViewModel;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public class HomeFragment extends BaseFragment<HomeViewModel> {
    private static final String TAG = HomeFragment.class.getSimpleName();

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.getWeather();
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
        mSubscriptions.add(mViewModel.onGetWeatherSuccess()
                .observeOn(AndroidSchedulers.mainThread())
                .filter(result -> result != null)
                .subscribe(weather -> {
                    Log.i(TAG, weather.toString());
                }));
    }

}
