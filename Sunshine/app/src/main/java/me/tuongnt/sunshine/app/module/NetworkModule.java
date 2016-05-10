package me.tuongnt.sunshine.app.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by TuongNguyen on 5/10/16.
 */
@Module
public class NetworkModule {
    private String mBaseUrl;
    private String mServerUrl;

    public NetworkModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    public NetworkModule(String serverUrl, String apiPath) {
        this(serverUrl + apiPath);

        mServerUrl = serverUrl;
    }

    @Provides
    @Named("server.url")
    public String providesServerUrl() {
        return mServerUrl;
    }


    @Provides
    @Singleton
    public Retrofit providesRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Define the interceptor, add authentication headers
        Interceptor interceptor = chain -> {
            Request.Builder builder = chain.request()
                    .newBuilder();
//            if (sessionRepository.getAuthKey() != null) {
//                builder.addHeader("Authorization", "Bearer " + sessionRepository.getAuthKey());
//            }
            Request newRequest = builder.build();
            return chain.proceed(newRequest);
        };

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        builder.interceptors().add(logging);
        OkHttpClient client = builder.build();

        RxJavaCallAdapterFactory rxAdapter =
                RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .client(client)
                .build();

        return retrofit;
    }
}
