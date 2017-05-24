package com.photon.templatemvp.data.remote;

import android.support.annotation.Nullable;


import com.photon.templatemvp.util.DebugLog;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by jumbada on 23/05/2017.
 */

public class RemoteConnection implements Callable<Object> {



  //  private RemoteComponent remoteComponent;


    private Object response;
   // @Inject Retrofit retrofit;


private void test () {

   //remoteComponent = DaggerRemoteComponent.builder().build();
  // remoteComponent.inject(this);
}


    private RemoteConnection() {
        test();

    }

    static RemoteConnection createGET()  {
        DebugLog.write();
        return new RemoteConnection();
    }

    public   <S> S createService(Class<S> serviceClass) {

      //  return retrofit.create(serviceClass);
        return  null;
    }


    private void connectToRemote(){


        MockyService service = null;
        try {
            retrofit2.Response response = service.getGalleryModel().execute();
            this.response = response.body();
            DebugLog.write(""+response.toString() + response.message() + response.code() + response.isSuccessful() + response.raw().toString());
        }
        catch (Exception r){}

    }


    /**
     * Do a request to an api synchronously.
     * It should not be executed in the main thread of the application.
     *
     * @return A string response
     */
    @Nullable
    Object requestSyncCall() {
        connectToRemote();
        return response;
    }

    @Override public Object call() throws Exception {
        return requestSyncCall();
    }
}
