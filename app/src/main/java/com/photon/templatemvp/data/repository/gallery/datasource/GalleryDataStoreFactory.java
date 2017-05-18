package com.photon.templatemvp.data.repository.gallery.datasource;

//**

import android.content.Context;
import android.support.annotation.NonNull;

import com.photon.templatemvp.data.cache.GalleryCache;
import com.photon.templatemvp.data.mapper.GalleryModelJsonMapper;
import com.photon.templatemvp.data.remote.MockyApi;
import com.photon.templatemvp.data.remote.MockyApiImpl;
import com.photon.templatemvp.util.DebugLog;

import javax.inject.Inject;
import javax.inject.Singleton;
/** Factory that creates different implementations of {@link GalleryDataStore}.
        */
@Singleton
public class GalleryDataStoreFactory {

    private final Context context;
   private final GalleryCache galleryCache;

    @Inject
    GalleryDataStoreFactory(@NonNull Context context) {
        this.context = context.getApplicationContext();
        galleryCache = null;
           }

    /**
     * Create {@link GalleryDataStore} from a gallery model.
     */
    public GalleryDataStore create() {
        //if needed, Cache-reading will be added here.
        GalleryDataStore galleryDataStore;
        DebugLog.write("createCloudDataStore()");
        return  galleryDataStore = createCloudDataStore();
        }

    /**
     * Create {@link GalleryDataStore} to retrieve data from the Cloud.
     */
    public GalleryDataStore createCloudDataStore() {
        final GalleryModelJsonMapper galleryModelJsonMapper = new GalleryModelJsonMapper();
        final MockyApi restApi = new MockyApiImpl(this.context, galleryModelJsonMapper) {
        };
        return new CloudGalleryDataStore(restApi, this.galleryCache);

    }
}
