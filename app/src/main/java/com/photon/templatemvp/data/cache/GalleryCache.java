package com.photon.templatemvp.data.cache;

import com.photon.templatemvp.data.model.gallery.GalleryModel;

import io.reactivex.Observable;

/**
 * An interface representing a user Cache.
 */
public interface GalleryCache {
    /**
     * Gets an {@link Observable} which will emit a {@link GalleryModel}.
     *
     * @param id The user id to retrieve data.
     */
    Observable<GalleryModel> get(final int id);

    /**
     * Puts and element into the cache.
     *
     * @param userEntity Element to insert in the cache.
     */
    void put(GalleryModel userEntity);

    /**
     * Checks if an element (Model) exists in the cache.
     *
     * @param id The id used to look for inside the cache.
     * @return true if the element is cached, otherwise false.
     */
    boolean isCached(final int id);

    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Evict all elements of the cache.
     */
    void evictAll();
}
