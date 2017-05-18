package com.photon.templatemvp.data.remote;

import com.photon.templatemvp.data.model.gallery.GalleryModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by jumbada on 12/05/2017.
 */

public interface MockyApi {

    String API_BASE_URL = "http://www.mocky.io";

    @GET("/v2/5915a54b1000007e037595fe")
     Observable<GalleryModel> getGalleryModel();

}
