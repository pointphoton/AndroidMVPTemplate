package com.photon.templatemvp.data.repository.gallery;



import  com.photon.templatemvp.data.model.User;
import com.photon.templatemvp.data.model.gallery.GalleryModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
/**
 * Created by jumbada on 11/05/2017.
 */

/**
 * Interface that represents a Repository for getting {@link com.photon.templatemvp.data.model.gallery.GalleryModel} related data.
 */
public interface GalleryRepository {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link  com.photon.templatemvp.data.model.gallery.GalleryModel}.
     */
    Observable<List<GalleryModel>> galleryModels();

    /**
     * Get an {@link rx.Observable} which will emit a {@link  com.photon.templatemvp.data.model.gallery.GalleryModel}.
     */
    Observable<GalleryModel> galleryModel();
}