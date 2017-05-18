package com.photon.templatemvp.data.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.photon.templatemvp.data.model.gallery.GalleryModel;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

/**
 * Class used to transform from Strings representing json to valid objects.
 */

public class GalleryModelJsonMapper {

        private final Gson gson;

        @Inject
        public GalleryModelJsonMapper() {
            this.gson = new Gson();
        }

        /**
         * Transform from valid json string to {@link GalleryModel}.
         *
         * @param galleryJsonResponse A json representing a user profile.
         * @return {@link GalleryModel}.
         * @throws JsonSyntaxException if the json string is not a valid json structure.
         */
        public GalleryModel transformGalleryModel(String galleryJsonResponse) throws JsonSyntaxException {
            final Type galleryModelType = new TypeToken<GalleryModel>() {}.getType();
            return this.gson.fromJson(galleryJsonResponse, galleryModelType);
        }

        /**
         * Transform from valid json string to List of {@link GalleryModel}.
         *
         * @param galleryListJsonResponse A json representing a collection of users.
         * @return List of {@link GalleryModel}.
         * @throws JsonSyntaxException if the json string is not a valid json structure.
         */
        public List<GalleryModel> transformGalleryModelCollection(String galleryListJsonResponse)
                throws JsonSyntaxException {
            final Type listOfGalleryModelType = new TypeToken<List<GalleryModel>>() {}.getType();
            return this.gson.fromJson(galleryListJsonResponse, listOfGalleryModelType);
        }
    }