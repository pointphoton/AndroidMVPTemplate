package com.photon.templatemvp.di.components;

/**
 * Created by jumbada on 03/05/2017.
 */

import android.content.Context;


import com.photon.templatemvp.data.remote.ServiceGeneratorImpl;
import com.photon.templatemvp.data.repository.gallery.GalleryRepository;
import com.photon.templatemvp.di.modules.ApplicationModule;
import com.photon.templatemvp.executor.PostExecutionThread;
import com.photon.templatemvp.executor.ThreadExecutor;
import com.photon.templatemvp.view.base.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    GalleryRepository userRepository();
   // ServiceGeneratorImpl serviceGenerator();

}
