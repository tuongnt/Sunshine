package me.tuongnt.sunshine.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.cantrowitz.rxbroadcast.RxBroadcast;

import rx.Observable;

/**
 * Created by TuongNguyen on 5/12/16.
 */
public final class NetworkManager {
    private final IntentFilter connectivityIntentFilter =
            new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
    private final Context appContext;
    private final ConnectivityManager connectivityManager;

    public NetworkManager(final Context context) {
        this.appContext = context.getApplicationContext();
        this.connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public boolean isNetworkAvailable() {
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public Observable<Boolean> connection() {
        return RxBroadcast
                .fromBroadcast(appContext, connectivityIntentFilter)
                .filter(intent -> ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
                .map(this::handleConnectivityStateChanged);
    }

    private boolean handleConnectivityStateChanged(final Intent intent) {
        final Bundle bundle = intent.getExtras();
        final boolean connected;
        if (bundle != null) {
            connected = !bundle.getBoolean(ConnectivityManager.EXTRA_NO_CONNECTIVITY);
        } else {
            connected = isNetworkAvailable();
        }
        return connected;
    }
}
