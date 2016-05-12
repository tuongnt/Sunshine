package me.tuongnt.sunshine.ui.home.view;

import android.util.Log;
import android.widget.ViewSwitcher;

import butterknife.Bind;
import me.tuongnt.sunshine.R;
import me.tuongnt.sunshine.app.component.AppComponent;
import me.tuongnt.sunshine.ui.SunshineError;
import me.tuongnt.sunshine.ui.common.BaseFragment;
import me.tuongnt.sunshine.ui.home.viewmodel.HomeViewModel;
import me.tuongnt.sunshine.ui.view.ErrorView;
import me.tuongnt.sunshine.utils.NetworkManager;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public class HomeFragment extends BaseFragment<HomeViewModel> {
    private static final String TAG = HomeFragment.class.getSimpleName();

    @Bind(R.id.content_switcher)
    ViewSwitcher mViewSwitcher;

    @Bind(R.id.error_view)
    ErrorView mErrorView;

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

        final NetworkManager networkManager = new NetworkManager(getContext());
        mSubscriptions.add(networkManager
                .connection()
                .subscribe(this::handleConnectionStateChanged));

        mSubscriptions.add(mViewModel.onGetWeatherSuccess()
                .observeOn(AndroidSchedulers.mainThread())
                .filter(result -> result != null)
                .subscribe(weather -> {
                    Log.i(TAG, weather.toString());
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
