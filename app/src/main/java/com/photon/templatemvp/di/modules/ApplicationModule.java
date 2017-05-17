package com.photon.templatemvp.di.modules;

/**
 * Created by jumbada on 03/05/2017.
 */

import android.content.Context;


import com.photon.templatemvp.BuildConfig;
import com.photon.templatemvp.application.JumbadaApp;
import com.photon.templatemvp.data.repository.UserDataRepository;
import com.photon.templatemvp.data.repository.UserRepository;
import com.photon.templatemvp.data.util.AppConstant;
import com.photon.templatemvp.data.util.StateManager;
import com.photon.templatemvp.data.util.StateManagerImpl;
import com.photon.templatemvp.util.Utils;
import com.photon.templatemvp.executor.JobExecutor;
import com.photon.templatemvp.executor.PostExecutionThread;
import com.photon.templatemvp.executor.SchedulerProvider;
import com.photon.templatemvp.executor.ThreadExecutor;
import com.photon.templatemvp.executor.UIThread;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final JumbadaApp application;

    public ApplicationModule(JumbadaApp application) {
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
    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }



    @Provides
    @Singleton
    @Named("isDebug")
    boolean provideIsDebug() {
        return BuildConfig.DEBUG;
    }

    @Provides
    @Singleton
    @Named("networkTimeoutInSeconds")
    int provideNetworkTimeoutInSeconds() {
        return AppConstant.NETWORK_CONNECTION_TIMEOUT;
    }

    @Provides
    @Singleton
    HttpUrl provideEndpoint() {
        return HttpUrl.parse(AppConstant.BASE_URL);
    }

    @Provides
    @Singleton
    SchedulerProvider provideAppScheduler() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    @Named("cacheSize")
    long provideCacheSize() {
        return AppConstant.CACHE_SIZE;
    }

    @Provides
    @Singleton
    @Named("cacheMaxAge")
    int provideCacheMaxAgeMinutes() {
        return AppConstant.CACHE_MAX_AGE;
    }

    @Provides
    @Singleton
    @Named("cacheMaxStale")
    int provideCacheMaxStaleDays() {
        return AppConstant.CACHE_MAX_STALE;
    }

    @Provides
    @Singleton
    @Named("retryCount")
    public int provideApiRetryCount() {
        return AppConstant.API_RETRY_COUNT;
    }

    @Provides
    @Singleton
    @Named("cacheDir")
    File provideCacheDir(Context context) {
        return context.getCacheDir();
    }

    @Provides
    @Named("isConnect")
    boolean provideIsConnect(Context context) {
        return Utils.isConnected(context);
    }


    @Provides
    @Singleton
    public StateManager provideStateManager(StateManagerImpl stateManager) {
        return stateManager;
    }


}
