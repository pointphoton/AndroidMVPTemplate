package com.photon.templatemvp.view.section.gallery;

import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.view.base.LoadDataView;

import java.util.Collection;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a entry profile.
 */
public interface GalleryListView extends LoadDataView {

    /**
     * Render a user list in the UI.
     *
     * @param entryModelCollection The collection of {@link GalleryModel} that will be shown.
     */
    void renderUserList(Collection<GalleryModel> entryModelCollection);

    /**
     * Render a user in the UI.
     *
     * @param entryModel The {@link GalleryModel} that will be shown.
     */
    void showEntryModel(GalleryModel entryModel);

}
