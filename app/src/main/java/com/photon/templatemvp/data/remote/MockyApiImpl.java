package com.photon.templatemvp.data.remote;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.photon.templatemvp.data.mapper.GalleryModelJsonMapper;
import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.exception.NetworkConnectionException;
import com.photon.templatemvp.util.DebugLog;

import java.lang.annotation.Retention;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * {@link MockyApi} implementation for retrieving data from the network.
 */
public class MockyApiImpl implements MockyApi {

    private final Context context;
    private final GalleryModelJsonMapper galleryModelJsonMapper;

    /**
     * Constructor of the class
     *
     * @param context                {@link android.content.Context}.
     * @param galleryModelJsonMapper {@link GalleryModelJsonMapper}.
     */
    public MockyApiImpl(Context context, GalleryModelJsonMapper galleryModelJsonMapper) {
        if (context == null || galleryModelJsonMapper == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
        this.galleryModelJsonMapper = galleryModelJsonMapper;
    }

    @Override
    public Observable<GalleryModel> getGalleryModel() {
        return Observable.create(emitter -> {
            if (isThereInternetConnection()) {
                DebugLog.write();
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder okHttpBuilder =  new OkHttpClient.Builder();
                okHttpBuilder.connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(logging);
                OkHttpClient client = okHttpBuilder.build();
                Retrofit retrofit =  retrofit = new Retrofit.Builder()
                        .baseUrl(MockyApi.API_BASE_URL).client(client)
                        .addConverterFactory(GsonConverterFactory.create(new Gson()))
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
                retrofit.create(MockyApi.class);
            }

        });
    }

    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }


}
