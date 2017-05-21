package com.photon.templatemvp.view.section.gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.photon.templatemvp.R;
import com.photon.templatemvp.di.HasComponent;
import com.photon.templatemvp.di.components.DaggerGalleryComponent;
import com.photon.templatemvp.di.components.GalleryComponent;
import com.photon.templatemvp.view.base.activity.BaseActivity;
import com.photon.templatemvp.view.section.main.MainActivity;

/**
 * Created by jumbada on 16/05/2017.
 */

public class GalleryActivity extends BaseActivity implements HasComponent<GalleryComponent> {


    private GalleryComponent galleryComponent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gallery;
    }

    @Override
    protected boolean requestFeatureIntermediateProgress() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.galleryFragmentContainer, new GalleryFragment());
        }
    }

    private void initializeInjector() {
        this.galleryComponent = DaggerGalleryComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public GalleryComponent getComponent() {
        return galleryComponent;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backWithExitAnimation();
    }
    public static Intent getCallingIntent(Context context) {
        return new Intent(context, GalleryActivity.class);
    }
}
