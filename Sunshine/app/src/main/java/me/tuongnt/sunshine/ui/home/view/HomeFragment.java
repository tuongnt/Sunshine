package me.tuongnt.sunshine.ui.home.view;

import me.tuongnt.sunshine.R;
import me.tuongnt.sunshine.app.component.AppComponent;
import me.tuongnt.sunshine.ui.common.BaseFragment;
import me.tuongnt.sunshine.ui.home.viewmodel.HomeViewModel;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public class HomeFragment extends BaseFragment<HomeViewModel> {

    @Override
    protected int getFragmentLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void inject(AppComponent appComponent) {

    }

    @Override
    protected void bindViewModel() {

    }


}
