
package com.photon.templatemvp.data.model.gallery;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Car {

    @SerializedName("models")
    private List<String> mModels;
    @SerializedName("name")
    private String mName;

    public List<String> getModels() {
        return mModels;
    }

    public void setModels(List<String> models) {
        mModels = models;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
