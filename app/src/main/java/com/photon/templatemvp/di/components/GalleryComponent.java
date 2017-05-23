package com.photon.templatemvp.di.components;

import com.photon.templatemvp.di.PerActivity;
import com.photon.templatemvp.di.modules.ActivityModule;
import com.photon.templatemvp.di.modules.GalleryModule;
import com.photon.templatemvp.view.section.gallery.GalleryFragment;

import dagger.Component;

/**
 * A scope {@link com.photon.templatemvp.di.PerActivity} component.
 * Injects gallery specific Fragments.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, GalleryModule.class})
public interface GalleryComponent extends ActivityComponent {
     void inject(GalleryFragment galleryFragment);

}

