package com.photon.templatemvp.di.components;

import com.photon.templatemvp.data.remote.MockyApi;
import com.photon.templatemvp.data.remote.MockyApiImpl;
import com.photon.templatemvp.data.remote.RemoteConnection;
import com.photon.templatemvp.di.modules.ActivityModule;
import com.photon.templatemvp.di.modules.ApplicationModule;
import com.photon.templatemvp.di.modules.RemoteModule;

import javax.inject.Singleton;

import dagger.Component;



@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {RemoteModule.class})
public interface RemoteComponent extends ApplicationComponent{

    void inject(MockyApiImpl mockyApiImpl);
}
