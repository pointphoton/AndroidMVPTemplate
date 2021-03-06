
package com.photon.templatemvp.data.model.gallery;


import com.google.gson.annotations.SerializedName;



public class GalleryModel {




    @SerializedName("properties")
    private Properties mProperties;
    @SerializedName("type")
    private String mType;



    public Properties getProperties() {
        return mProperties;
    }

    public void setProperties(Properties properties) {
        mProperties = properties;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
