package com.photon.templatemvp.application;

import android.app.Application;

import com.photon.templatemvp.di.components.ApplicationComponent;
import com.squareup.leakcanary.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by jumbada on 11/05/2017.
 */

public class JumbadaApp  extends Application {

    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }


    private void initializeInjector() {
/*
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
                */

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