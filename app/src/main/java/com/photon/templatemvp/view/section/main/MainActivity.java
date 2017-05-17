package com.photon.templatemvp.view.section.main;

import android.os.Bundle;

import com.photon.templatemvp.R;
import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.view.base.BaseActivity;

import butterknife.OnClick;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * Goes to the gallery list screen.
     */
   /*
    void navigateToGallery() {
        DebugLog.write(this.getClass().getSimpleName(),"navigateToGallery()");
        this.navigator.navigateToGalleryScreen(this);
    }
    */
}
