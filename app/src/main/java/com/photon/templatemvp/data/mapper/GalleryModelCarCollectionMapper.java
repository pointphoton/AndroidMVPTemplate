package com.photon.templatemvp.data.mapper;

import com.photon.templatemvp.di.PerActivity;
import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.data.model.gallery.Car;
import com.photon.templatemvp.util.Utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pointphoton on 21/05/2017.
 */

@PerActivity
public class GalleryModelCarCollectionMapper {

    @Inject
    public GalleryModelCarCollectionMapper() {}

    /**
     * Transform a {@link GalleryModel} into a collection of {@link Car}.
     *
     * @param galleryModel Object to be transformed.
     * @return {@link Collection<Car>}.
     */
    public Collection<Car> transform(final GalleryModel galleryModel){
        if (galleryModel == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
       List<Car> cars = Utils.checkNotNull(Utils.checkNotNull(Utils.checkNotNull(galleryModel.getProperties()).getPerson()).getCars());
       return cars;


    }

}
