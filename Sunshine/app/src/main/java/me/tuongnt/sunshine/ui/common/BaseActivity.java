package me.tuongnt.sunshine.ui.common;

import android.support.v7.app.AppCompatActivity;

import me.tuongnt.sunshine.app.SunshineApp;
import me.tuongnt.sunshine.app.component.AppComponent;
import rx.internal.util.SubscriptionList;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected SubscriptionList mSubscriptions;

    protected abstract void inject(AppComponent appComponent);

    protected abstract void bindViewModel();

    protected AppComponent getAppComponent() {
        return ((SunshineApp) getApplication()).getAppComponent();
    }

    @Override
    public void onStart() {
        super.onStart();
        mSubscriptions = new SubscriptionList();
        inject(getAppComponent());
        bindViewModel();
    }

    @Override
    public void onStop() {
        super.onStop();
        mSubscriptions.unsubscribe();
    }

}
