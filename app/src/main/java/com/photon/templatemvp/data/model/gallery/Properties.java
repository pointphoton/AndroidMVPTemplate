
package com.photon.templatemvp.data.model.gallery;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Properties {

    @SerializedName("person")
    private Person mPerson;
    @SerializedName("service")
    private Service mService;

    public Person getPerson() {
        return mPerson;
    }

    public void setPerson(Person person) {
        mPerson = person;
    }

    public Service getService() {
        return mService;
    }

    public void setService(Service service) {
        mService = service;
    }

}
