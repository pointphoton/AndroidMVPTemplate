package com.photon.templatemvp.view.section.gallery;

import com.photon.templatemvp.data.model.gallery.Car;
import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.view.base.view.LoadDataView;

import java.util.Collection;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a entry profile.
 */
public interface GalleryView extends LoadDataView {

    /**
     * Render a car list in the UI.
     *
     * @param entryModelCollection The collection of {@link GalleryModel} that will be shown.
     */
    void renderUserList(Collection<GalleryModel> entryModelCollection);

    /**
     * Render a car in the UI.
     *
     * @param car The {@link Car} that will be shown.
     */
    void showCarModel(Car car);

}
