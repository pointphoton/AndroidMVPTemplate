package com.photon.templatemvp.di.components;

/**
 * Created by jumbada on 03/05/2017.
 */



import com.photon.templatemvp.di.PerActivity;
import com.photon.templatemvp.di.modules.ActivityModule;
import com.photon.templatemvp.di.modules.UserModule;

import dagger.Component;

/**
 * A scope {@link com.photon.templatemvp.di.PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
   // void inject(UserListFragment userListFragment);
   // void inject(UserDetailsFragment userDetailsFragment);
}
