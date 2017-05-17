package com.photon.templatemvp.di.components;

/**
 * Created by jumbada on 03/05/2017.
 */


import android.support.v7.app.AppCompatActivity;

import com.photon.templatemvp.di.PerActivity;
import com.photon.templatemvp.di.modules.ActivityModule;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link com.photon.templatemvp.di.PerActivity}
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
    //Exposed to sub-graphs.
    AppCompatActivity activity();
}
