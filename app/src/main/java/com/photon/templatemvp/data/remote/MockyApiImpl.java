package com.photon.templatemvp.data.remote;

import android.content.Context;
import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.exception.NetworkServiceException;
import com.photon.templatemvp.exception.ServiceErrorGenerator;
import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.util.Utils;
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


    /**
     * Constructor of the class
     *
     * @param context                {@link android.content.Context}.
     */
    public MockyApiImpl(Context context, Retrofit retrofit) {
        if (context == null || retrofit == null) {
        throw new IllegalArgumentException();
        }

            this.context = context.getApplicationContext();
            this.retrofit = retrofit;



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
                        final GalleryModel model = getGalleryModelFromApi(response);
                        emitter.onNext(model);
                        emitter.onComplete();
                    } catch (Exception ex) {
                        DebugLog.write(ex.getMessage() + " _ " + ex.getCause());
                        emitter.onError(ex);
                    }
                } else {
                    emitter.onError(new NetworkServiceException(true,ServiceErrorGenerator.SERVER_ERROR_MESSAGE,new Throwable(ServiceErrorGenerator.SERVER_ERROR_MESSAGE)));
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
       return Utils.isThereInternetConnection(context);
    }




    @SuppressWarnings("unchecked")
    private GalleryModel getGalleryModelFromApi(final Response<GalleryModel> response) throws Exception {
        ServiceResponse.ModelObjectResponse<GalleryModel> sm =  ServiceResponse.ModelObjectResponse.build(response);
        return sm.requestSyncCall();

    }


}
