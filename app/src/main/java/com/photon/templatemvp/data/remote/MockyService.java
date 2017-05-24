package com.photon.templatemvp.data.remote;

import com.photon.templatemvp.data.model.gallery.GalleryModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pointphoton on 22/05/2017.
 */

public interface MockyService {



    @GET("/v2/5915a54b1000007e037595fe")
    Call<GalleryModel> getGalleryModel();
}
