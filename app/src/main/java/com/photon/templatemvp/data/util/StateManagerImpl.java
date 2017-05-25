package com.photon.templatemvp.data.util;

import android.content.Context;

import com.photon.templatemvp.util.Utils;

import javax.inject.Inject;


public class StateManagerImpl implements StateManager {

    private Context context;

    @Inject
    public StateManagerImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean isConnect() {
        return false;
    }
}
