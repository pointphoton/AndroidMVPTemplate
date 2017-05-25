package com.photon.templatemvp.data.remote;


import android.support.annotation.Nullable;

import com.photon.templatemvp.exception.NetworkServiceException;
import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.util.Utils;

import java.util.Collection;
import java.util.concurrent.Callable;

import retrofit2.Response;

/**
 * Api Connection class used to retrieve data from the cloud.
 * Implements {@link java.util.concurrent.Callable} so when executed asynchronously can
 * return a value.
 */
public class ServiceResponseOld<T> implements Callable<T> {




    private Response<T> response;
    private  T model;
    private Collection<T> modelCollection;
    private NetworkServiceException testException;

    private ServiceResponseOld(final Response<T> response) {
        this.response = response;
    }
    @SuppressWarnings("unchecked")
   public  static <T> ServiceResponseOld buildModel(final Response<T> response){
  //     ServiceResponseOld.buildType = BuildType.MODEL;
        return new ServiceResponseOld(response);
    }
    @SuppressWarnings("unchecked")
    public  static <T> ServiceResponseOld buildModelCollection(final Response<T> response){
        //ServiceResponseOld.buildType = BuildType.COLLECTION;
        return new ServiceResponseOld(response);
    }

    @Nullable
    T requestSyncCall() throws Exception {

        checkResponse();

        return model;
    }
/*
    @Nullable
    Collection<T> requestSyncCallCollection() throws Exception {

        checkResponse();

        return modelCollection;
    }
*/
    private void checkResponse() throws Exception{
        Utils.checkNotNull(this.response);
        DebugLog.write("message :" + response.message());
        DebugLog.write("code :" + response.code());
        DebugLog.write("isSuccessful :" + response.isSuccessful());
        if (response.code() != 200){
            model = response.body();
        }
        else {
            //this.testException = new NetworkServiceException("exception message deneme",new Throwable("cause deneme"));
            //throw testException;
        }


    }


    @Override
    public T call() throws Exception {
        return requestSyncCall();
    }
/*
    @Override
    public Collection<T> call() throws Exception {
        return requestSyncCallCollection();
    }
    */
}
