package com.photon.templatemvp.data.remote;


import com.google.gson.Gson;
import com.photon.templatemvp.data.model.gallery.GalleryModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pointphoton on 20/05/2017.
 */

public class MockyApiConnection {


    static public void connect (){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpBuilder =  new OkHttpClient.Builder();
        okHttpBuilder.connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(logging);
        OkHttpClient client = okHttpBuilder.build();
        Retrofit retrofit =   new Retrofit.Builder()
                .baseUrl(MockyApi.API_BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        MockyApi mockyApi = retrofit.create(MockyApi.class);
        mockyApi.getGalleryModel();
    }
}
