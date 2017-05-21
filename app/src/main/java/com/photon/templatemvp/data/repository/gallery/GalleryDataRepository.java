package com.photon.templatemvp.data.repository.gallery;

/**
 * Created by jumbada on 11/05/2017.
 */


import android.telecom.Call;

import com.photon.templatemvp.data.model.User;
import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.data.repository.gallery.datasource.GalleryDataStore;
import com.photon.templatemvp.data.repository.gallery.datasource.GalleryDataStoreFactory;
import com.photon.templatemvp.util.DebugLog;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link GalleryRepository} for retrieving user data.
 */
@Singleton
public class GalleryDataRepository implements GalleryRepository {

    private final GalleryDataStoreFactory galleryDataStoreFactory;

    /**
     * Constructs a {@link GalleryRepository}.
     * @param dataStoreFactory A factory to construct different data source implementations.
     */
    @Inject
    GalleryDataRepository(GalleryDataStoreFactory dataStoreFactory) {
        this.galleryDataStoreFactory = dataStoreFactory;
    }

    @Override
    public Observable<List<GalleryModel>> galleryModels() {
        DebugLog.write("this.galleryDataStoreFactory.createCloudDataStore()");
        //we always get all users from the cloud
        final GalleryDataStore galleryDataStore = this.galleryDataStoreFactory.createCloudDataStore();
        return galleryDataStore.galleryModelList();
    }

    @Override
    public Observable<GalleryModel> galleryModel() {
        DebugLog.write("this.galleryDataStoreFactory.createCloudDataStore()");
        final GalleryDataStore galleryDataStore = this.galleryDataStoreFactory.createCloudDataStore();
        return galleryDataStore.galleryModel();
    }
}