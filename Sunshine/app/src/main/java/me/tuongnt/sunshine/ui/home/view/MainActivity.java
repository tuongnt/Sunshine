package me.tuongnt.sunshine.ui.home.view;

import android.os.Bundle;

import me.tuongnt.sunshine.R;
import me.tuongnt.sunshine.ui.common.SimpleActivity;

public class MainActivity extends SimpleActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addFragment(new HomeFragment(), false);
    }
}
