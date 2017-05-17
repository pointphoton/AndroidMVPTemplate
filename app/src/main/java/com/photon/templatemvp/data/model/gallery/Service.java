
package com.photon.templatemvp.data.model.gallery;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Service {

    @SerializedName("name")
    private String mName;
    @SerializedName("usageCount")
    private Long mUsageCount;
    @SerializedName("year")
    private Long mYear;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getUsageCount() {
        return mUsageCount;
    }

    public void setUsageCount(Long usageCount) {
        mUsageCount = usageCount;
    }

    public Long getYear() {
        return mYear;
    }

    public void setYear(Long year) {
        mYear = year;
    }

}
