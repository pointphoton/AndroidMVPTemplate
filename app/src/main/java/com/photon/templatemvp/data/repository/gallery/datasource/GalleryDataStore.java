package com.photon.templatemvp.data.repository.gallery.datasource;

/**
 * Created by jumbada on 18/05/2017.
 */

import com.photon.templatemvp.data.model.gallery.GalleryModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface GalleryDataStore {
    /**
     * Get an {@link Observable} which will emit a List of {@link GalleryModel}.
     */
    Observable<List<GalleryModel>> galleryModelList();

    /**
     * Get an {@link Observable} which will emit a {@link GalleryModel}.
     *
     *
     */
    Observable<GalleryModel> galleryModel();
}
