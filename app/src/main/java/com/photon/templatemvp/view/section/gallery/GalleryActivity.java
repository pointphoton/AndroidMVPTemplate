package com.photon.templatemvp.view.section.gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.photon.templatemvp.R;
import com.photon.templatemvp.di.HasComponent;
import com.photon.templatemvp.di.components.GalleryComponent;
import com.photon.templatemvp.view.base.activity.BaseActivity;
import com.photon.templatemvp.view.section.main.MainActivity;

/**
 * Created by jumbada on 16/05/2017.
 */

public class GalleryActivity extends BaseActivity implements HasComponent<GalleryComponent> {


    private GalleryComponent galleryComponent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_gallery;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        return new Intent(context, MainActivity.class);
    }
}
