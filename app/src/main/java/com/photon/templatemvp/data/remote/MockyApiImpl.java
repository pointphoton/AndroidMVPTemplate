package com.photon.templatemvp.data.remote;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.photon.templatemvp.data.mapper.GalleryModelJsonMapper;
import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.di.components.DaggerRemoteComponent;
import com.photon.templatemvp.di.components.RemoteComponent;
import com.photon.templatemvp.exception.NetworkConnectionException;
import com.photon.templatemvp.util.DebugLog;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * {@link MockyApi} implementation for retrieving data from the network.
 */
public class MockyApiImpl implements MockyApi {

    @Inject Retrofit retrofit;

    private RemoteComponent remoteComponent;
    private final Context context;
    private final GalleryModelJsonMapper galleryModelJsonMapper;
    //private final RemoteComponent remoteComponent;


    private void initializeInjector () {

        remoteComponent = DaggerRemoteComponent.builder().build();
        remoteComponent.inject(this);
    }


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
        initializeInjector();
        this.context = context.getApplicationContext();
        this.galleryModelJsonMapper = galleryModelJsonMapper;

    }

    @Override
    public Observable<GalleryModel> getGalleryModel() {
        DebugLog.write();

        return Observable.create(new ObservableOnSubscribe<GalleryModel>() {

            @Override
            public void subscribe(ObservableEmitter<GalleryModel> emitter) throws Exception {

                try {

                    MockyService service = retrofit.create(MockyService.class);
                    retrofit2.Response response = service.getGalleryModel().execute();
                    //DebugLog.write(""+response.toString() + response.message() + response.code() + response.isSuccessful() + response.raw().toString());
                    emitter.onNext((GalleryModel) response.body());
                    emitter.onComplete();
                }
                catch (Exception ex){
                    emitter.onError(new NetworkConnectionException(ex.getCause()));
                }
            }
        });
        /*
        return   Observable.create(new ObservableOnSubscribe<GalleryModel>() {
            @Override
            public void subscribe(ObservableEmitter<GalleryModel> e) throws Exception {

                if (isThereInternetConnection()){
                    try{
                      //  MockyService service =serviceGenerator.createService(MockyService.class ,MockyService.API_BASE_URL);
                        MockyService service = retrofit.create(MockyService.class);
                        retrofit2.Response response = service.getGalleryModel().execute();
                        DebugLog.write(""+response.toString() + response.message() + response.code() + response.isSuccessful() + response.raw().toString());

                        e.onNext((GalleryModel) response.body());
                        e.onComplete();
                    }
                    catch (Exception ex){
                        e.onError(new NetworkConnectionException(ex.getCause()));
                    }
                }
                else {
                    e.onError(new NetworkConnectionException());
                }


              

            }
        });
*/
        //retrofit
/*
//old standart
      return   Observable.create(new ObservableOnSubscribe<GalleryModel>() {
            @Override
            public void subscribe(ObservableEmitter<GalleryModel> e) throws Exception {
                e.onNext(galleryModelJsonMapper.transformGalleryModel(getGalleryModelFromApi()));
                e.onError(new NetworkConnectionException());
                e.onComplete();
            }
        });
        */

        /*
        //old lambda
        return Observable.create(emitter -> {
            if (isThereInternetConnection()) {
                try {

                    String responseUserDetails = getGalleryModelFromApi();
                    if (responseUserDetails != null) {
                        emitter.onNext(galleryModelJsonMapper.transformGalleryModel(responseUserDetails));
                        emitter.onComplete();
                    } else {
                        emitter.onError(new NetworkConnectionException());
                    }
                } catch (Exception e) {
                    emitter.onError(new NetworkConnectionException(e.getCause()));
                }
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
        */

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
