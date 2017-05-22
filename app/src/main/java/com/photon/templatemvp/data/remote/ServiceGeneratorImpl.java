package com.photon.templatemvp.data.remote;

import com.google.gson.Gson;
import com.photon.templatemvp.BuildConfig;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



@Singleton
public class ServiceGeneratorImpl {

    //Network constants
    private final int TIMEOUT_CONNECT = 30;   //In seconds
    private final int TIMEOUT_READ = 30;   //In seconds
    private final String CONTENT_TYPE = "Content-Type";
    private final String API_KEY = "apikey";
    private final String CONTENT_TYPE_VALUE = "application/json";
    private final String API_KEY_VALUE = "0bac85d8945140b3bc8dde8aff16e329";

    private OkHttpClient.Builder okHttpBuilder;
    private Retrofit retrofit;
    private Gson gson;

    @Inject
    public ServiceGeneratorImpl() {
        this.okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.addInterceptor(headerInterceptor);
        okHttpBuilder.addInterceptor(getLogger());
        okHttpBuilder.connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(TIMEOUT_READ, TimeUnit.SECONDS);
        this.gson = new Gson();
    }

    public <S> S createService(Class<S> serviceClass, String baseUrl) {
        OkHttpClient client = okHttpBuilder.build();
        retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl).client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
           .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        return retrofit.create(serviceClass);
    }

    Interceptor headerInterceptor = chain -> {
        Request original = chain.request();

        Request request = original.newBuilder()
            .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
            .method(original.method(), original.body())
            .build();

        return chain.proceed(request);
    };

    private HttpLoggingInterceptor getLogger() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS).setLevel
                (HttpLoggingInterceptor.Level.BODY);
        }
        return loggingInterceptor;
    }
}