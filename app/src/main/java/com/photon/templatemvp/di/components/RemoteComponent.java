package com.photon.templatemvp.di.components;

import android.content.Context;

import com.photon.templatemvp.data.remote.MockyApi;
import com.photon.templatemvp.data.remote.MockyApiImpl;
import com.photon.templatemvp.data.remote.RemoteConnection;
import com.photon.templatemvp.di.modules.ActivityModule;
import com.photon.templatemvp.di.modules.ApplicationModule;
import com.photon.templatemvp.di.modules.RemoteModule;
import com.photon.templatemvp.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;


@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {RemoteModule.class})
public interface RemoteComponent {

    void inject(MockyApiImpl mockyApiImpl);

    //Exposed to sub-graphs.
    Context context();
    Retrofit getRetrofit();
}
