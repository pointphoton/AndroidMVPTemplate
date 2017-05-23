package com.photon.templatemvp.di.modules;

/**
 * Created by jumbada on 03/05/2017.
 */

import android.content.Context;


import com.photon.templatemvp.BuildConfig;
import com.photon.templatemvp.application.TemplateApp;
import com.photon.templatemvp.data.remote.ServiceGeneratorImpl;
import com.photon.templatemvp.data.repository.gallery.GalleryDataRepository;
import com.photon.templatemvp.data.repository.gallery.GalleryRepository;
import com.photon.templatemvp.executor.JobExecutor;
import com.photon.templatemvp.executor.PostExecutionThread;
import com.photon.templatemvp.executor.ThreadExecutor;
import com.photon.templatemvp.executor.UIThread;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final TemplateApp application;

    public ApplicationModule(TemplateApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    /*
    @Provides @Singleton
    UserCache provideUserCache(UserCacheImpl userCache) {
        return userCache;
    }
    */

    @Provides @Singleton
    GalleryRepository provideGalleryRepository(GalleryDataRepository galleryDataRepository) {
        return galleryDataRepository;
    }

    @Provides
    @Singleton
    @Named("cacheDir")
    File provideCacheDir() {
        return application.getCacheDir();
    }



}
