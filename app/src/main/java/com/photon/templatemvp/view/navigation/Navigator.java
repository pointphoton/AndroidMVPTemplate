package com.photon.templatemvp.view.navigation;

/**
 * Created by jumbada on 03/05/2017.
 */

import android.content.Intent;


import com.photon.templatemvp.R;
import com.photon.templatemvp.view.base.BaseActivity;
import com.photon.templatemvp.view.section.gallery.GalleryActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
        //empty
    }

    /**
     * Goes to the {@link GalleryActivity} screen.
     *
     * @param activity A Activity needed to open with animation the destiny activity.
     */
    public void navigateToGalleryScreen(BaseActivity activity) {
        if (activity != null) {
            Intent intentToLaunch = GalleryActivity.getCallingIntent(activity);
            activity.startActivity(intentToLaunch);
            activity.overridePendingTransition(R.anim.anim_slide_in_right,
                    R.anim.anim_slide_out_right);

        }
    }


}
