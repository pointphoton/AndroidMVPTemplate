/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.photon.templatemvp.view.section.gallery;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Layout manager to position items inside a {@link android.support.v7.widget.RecyclerView}.
 */
public class GalleryLayoutManager extends LinearLayoutManager {
  public GalleryLayoutManager(Context context) {
    super(context);
  }
}
