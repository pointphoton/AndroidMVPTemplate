package com.photon.templatemvp.view.section.gallery;

import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.view.base.BaseFragment;

/**
 * Created by jumbada on 16/05/2017.
 */

public class GalleryFragment extends BaseFragment {

    private static final String TEST_PARAM_GALLERY_ID = "test_param_gallery_id";


    public GalleryFragment() {
        DebugLog.write(this.getClass().getSimpleName(),"GalleryFragment() setRetainInstance(true)");
        setRetainInstance(true);
    }

}
