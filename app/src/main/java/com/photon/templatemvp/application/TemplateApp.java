package com.photon.templatemvp.application;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.photon.templatemvp.di.components.ApplicationComponent;
import com.photon.templatemvp.di.components.DaggerApplicationComponent;
import com.photon.templatemvp.di.modules.ApplicationModule;

import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.view.section.main.MainActivity;
import com.squareup.leakcanary.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by jumbada on 11/05/2017.
 */

public class TemplateApp extends Application {

    private ApplicationComponent applicationComponent;
    private boolean isUIThread(){
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
        // Setup handler for uncaught exceptions.
        Thread.setDefaultUncaughtExceptionHandler (new Thread.UncaughtExceptionHandler()
        {
            @Override
            public void uncaughtException (Thread thread, Throwable e)
            {
                handleUncaughtException (thread, e);
            }
        });

    }
    public void handleUncaughtException(Thread thread, Throwable e) {
        e.printStackTrace(); // not all Android versions will print the stack trace automatically

        if(isUIThread()) {
            invokeLogActivity();
        }else{  //handle non UI thread throw uncaught exception

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    invokeLogActivity();
                }
            });
        }
    }

    private void invokeLogActivity(){
        DebugLog.write();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
       startActivity (intent);

       // System.exit(1); // kill off the crashed app
    }

    private void initializeInjector() {

        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))

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