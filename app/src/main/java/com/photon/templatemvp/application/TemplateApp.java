package com.photon.templatemvp.application;

import android.app.Application;

import com.photon.templatemvp.di.components.ApplicationComponent;
import com.photon.templatemvp.di.components.DaggerApplicationComponent;
import com.photon.templatemvp.di.components.DaggerRemoteComponent;
import com.photon.templatemvp.di.components.RemoteComponent;
import com.photon.templatemvp.di.modules.ApplicationModule;
import com.photon.templatemvp.di.modules.RemoteModule;
import com.squareup.leakcanary.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

import retrofit2.Retrofit;

/**
 * Created by jumbada on 11/05/2017.
 */

public class TemplateApp extends Application {

    private ApplicationComponent applicationComponent;
    private RemoteComponent remoteComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();

    }


    private void initializeInjector() {

        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))

                .build();
        this.remoteComponent = DaggerRemoteComponent.builder()
                .remoteModule(new RemoteModule(this))
                .build();



    }




    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}