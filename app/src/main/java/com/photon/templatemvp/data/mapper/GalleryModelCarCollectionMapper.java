package com.photon.templatemvp.data.mapper;

import com.photon.templatemvp.data.model.gallery.Person;
import com.photon.templatemvp.data.model.gallery.Properties;
import com.photon.templatemvp.di.PerActivity;
import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.data.model.gallery.Car;
import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.util.Utils;

import java.lang.annotation.Target;
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
     * @throws IllegalArgumentException if {@code model} is null
     * @throws NullPointerException if {@code the member(s) of the model} is null
     * @throws Exception
     */
    public Collection<Car> transform(final GalleryModel galleryModel) throws Exception{
        if (galleryModel == null) {
            DebugLog.write();
            throw new IllegalArgumentException("Cannot transform a null " + GalleryModel.class.getSimpleName());
        }
       DebugLog.write();
       Properties properties = Utils.checkNotNull(galleryModel.getProperties(), Properties.class.getSimpleName());
       Person person =  Utils.checkNotNull(properties.getPerson());
       List<Car> cars = Utils.checkNotNull(person.getCars());
       return cars;


    }

}
