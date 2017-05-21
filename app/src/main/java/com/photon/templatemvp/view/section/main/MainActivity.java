package com.photon.templatemvp.view.section.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.photon.templatemvp.R;
import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.view.base.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean requestFeatureIntermediateProgress() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

    }



    /**
     * Goes to the gallery list screen.
     */
   @OnClick(R.id.mainButtonEnter)
    void navigateToGallery() {
        DebugLog.write("navigateToGallery()");
        this.navigator.navigateToGalleryScreen(this);
    }

}
