package me.tuongnt.sunshine.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import me.tuongnt.sunshine.app.SunshineApp;
import me.tuongnt.sunshine.app.component.AppComponent;
import rx.internal.util.SubscriptionList;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public abstract class BaseFragment<ViewModel> extends Fragment {
    @Inject
    protected ViewModel mViewModel;
    protected SubscriptionList mSubscriptions;

    protected abstract int getFragmentLayoutResId();

    protected abstract void inject(AppComponent appComponent);

    protected abstract void bindViewModel();

    @Override
    public void onStart() {
        super.onStart();

        mSubscriptions = new SubscriptionList();
        inject(getAppComponent());

        bindViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayoutResId(), null);
        ButterKnife.bind(this, view);
        initView(savedInstanceState);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        mSubscriptions.unsubscribe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    protected AppComponent getAppComponent() {
        return ((SunshineApp) getActivity().getApplication()).getAppComponent();
    }

    protected void initView(Bundle savedInstanceState) {

    }

}
