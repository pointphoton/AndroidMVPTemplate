package com.photon.templatemvp.data.remote;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.photon.templatemvp.data.mapper.GalleryModelJsonMapper;
import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.exception.NetworkConnectionException;
import com.photon.templatemvp.exception.TestException;
import com.photon.templatemvp.util.DebugLog;

import javax.crypto.spec.DESedeKeySpec;
import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * {@link MockyApi} implementation for retrieving data from the network.
 */
public class MockyApiImpl implements MockyApi {

    private Retrofit retrofit;
    private  MockyService service;

    private final Context context;
   // private final GalleryModelJsonMapper galleryModelJsonMapper;
    //private final RemoteComponent remoteComponent;


    interface Testable{

        void getModel(Object model);
        void onError(String errorType);
    }

    class Test implements Testable {


        @Override
        public void getModel(Object model) {
            DebugLog.write("testable "+model.toString());
            //return null;
        }

        @Override
        public void onError(String errorType) {
            DebugLog.write("testable "+errorType);

        }
    }



    /**
     * Constructor of the class
     *
     * @param context                {@link android.content.Context}.

     */
    public MockyApiImpl(Context context, Retrofit retrofit) {
        if (context == null ) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }

        this.context = context.getApplicationContext();
        this.retrofit = retrofit;

    }

    private void res (Response response,Testable testable) {
        DebugLog.write("message :" + response.message());
        DebugLog.write("code :" + response.code());
        DebugLog.write("isSuccessful :" + response.isSuccessful());
        if(response.code() == 200){
             testable.getModel(response.body());
           // return response.body();
        }
        else{
            testable.onError("error test...");
        }



    }

    @Override
    public Observable<GalleryModel> getGalleryModel() {
        DebugLog.write();

        return Observable.create(new ObservableOnSubscribe<GalleryModel>() {

            @Override
            public void subscribe(ObservableEmitter<GalleryModel> emitter) throws Exception {
                if (isThereInternetConnection()) {
                    try {


                        service = retrofit.create(MockyService.class);
                        retrofit2.Response<GalleryModel> response = service.getGalleryModel().execute();
                        Test t = new Test();
                        res(response,t);


                        //DebugLog.write(""+response.toString() + response.message() + response.code() + response.isSuccessful() + response.raw().toString());

                     //   emitter.onNext((GalleryModel) response.body());
                        //emitter.onNext(new GalleryModel());
                     //   emitter.onComplete();
                    } catch (Exception ex) {
                        DebugLog.write(ex.getCause() + " _ " + ex.getMessage());
                        // show message , logging message
                        emitter.onError(new TestException("SHOW THIS MESSAGE  ",  ex.getCause()));
                    }
                } else {
                   // emitter.onError(new NetworkConnectionException("no internet!!!"));
                    emitter.onError(new NetworkConnectionException());
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
