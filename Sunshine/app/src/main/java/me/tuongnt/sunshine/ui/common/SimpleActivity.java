package me.tuongnt.sunshine.ui.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import me.tuongnt.sunshine.R;
import me.tuongnt.sunshine.app.component.AppComponent;

/**
 * Created by TuongNguyen on 5/10/16.
 */
public class SimpleActivity extends BaseActivity {
    protected Toolbar mToolbar;

    @Override
    protected void inject(AppComponent appComponent) {

    }

    @Override
    protected void bindViewModel() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    protected void addFragment(Fragment fragment, boolean isBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contain_main,
                        fragment,
                        fragment.getClass().getSimpleName());

        if (isBackStack) {
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commit();
    }
}
