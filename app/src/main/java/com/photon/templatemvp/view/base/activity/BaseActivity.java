package com.photon.templatemvp.view.base.activity;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


import com.photon.templatemvp.R;
import com.photon.templatemvp.application.TemplateApp;
import com.photon.templatemvp.di.components.ApplicationComponent;
import com.photon.templatemvp.di.modules.ActivityModule;
import com.photon.templatemvp.view.navigation.Navigator;

import javax.inject.Inject;



/**
 * Base {@link android.app.Activity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    protected Navigator navigator;

    public abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        this.getApplicationComponent().inject(this);
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link  com.photon.templatemvp.di.components.ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((TemplateApp) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     *
     * @return {@link com.photon.templatemvp.di.modules.ActivityModule}
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }



    /**
    *  Adds leaving transition effect.
    */
    protected void backWithExitAnimation(){
        this.overridePendingTransition(R.anim.anim_slide_in_right,
                R.anim.anim_slide_out_right);
    }

}
