package me.tuongnt.sunshine.ui.home.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.tuongnt.sunshine.R;
import me.tuongnt.sunshine.app.component.AppComponent;
import me.tuongnt.sunshine.ui.common.BaseFragment;
import me.tuongnt.sunshine.ui.home.viewmodel.HomeViewModel;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public class HomeFragment extends BaseFragment<HomeViewModel> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                .filter(result -> result != null)
                .subscribe(weather -> {

                }));
    }


}
