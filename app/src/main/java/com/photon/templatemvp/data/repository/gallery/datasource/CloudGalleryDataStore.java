package com.photon.templatemvp.data.repository.gallery.datasource;


import com.photon.templatemvp.data.cache.GalleryCache;
import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.data.remote.MockyApi;
import com.photon.templatemvp.util.DebugLog;

import java.util.List;

import io.reactivex.Observable;

/**
 * {@link GalleryDataStore} implementation based on connections to the api (Cloud).
 */
public class CloudGalleryDataStore implements GalleryDataStore {

    private final MockyApi mockyApi;
    private final GalleryCache galleryCache;

    /**
     * Construct a {@link GalleryDataStore} based on connections to the api (Cloud).
     *
     * @param mockyApi The {@link MockyApi} implementation to use.
     * @param galleryCache A {@link GalleryCache} to cache data retrieved from the api.
     */
    CloudGalleryDataStore(MockyApi mockyApi, GalleryCache galleryCache) {
        this.mockyApi = mockyApi;
        this.galleryCache = galleryCache;
    }

    @Override
    public Observable<List<GalleryModel>> galleryModelList() {
        return null;
    }

    @Override
    public Observable<GalleryModel> galleryModel() {
        DebugLog.write("return this.mockyApi.getGalleryModel()");
        return this.mockyApi.getGalleryModel();
    }
}
