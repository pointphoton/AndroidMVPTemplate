package com.photon.templatemvp.di.components;

import com.photon.templatemvp.di.PerActivity;
import com.photon.templatemvp.di.modules.ActivityModule;
import com.photon.templatemvp.di.modules.UserModule;
import com.photon.templatemvp.view.section.gallery.GalleryFragment;

import dagger.Component;

/**
 * A scope {@link com.photon.templatemvp.di.PerActivity} component.
 * Injects user specific Fragments.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface GalleryComponent extends ActivityComponent {
     void inject(GalleryFragment galleryFragment);

}

