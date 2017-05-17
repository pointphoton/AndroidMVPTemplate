
package com.photon.templatemvp.data.model.gallery;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Person {

    @SerializedName("age")
    private Long mAge;
    @SerializedName("cars")
    private List<Car> mCars;
    @SerializedName("name")
    private String mName;

    public Long getAge() {
        return mAge;
    }

    public void setAge(Long age) {
        mAge = age;
    }

    public List<Car> getCars() {
        return mCars;
    }

    public void setCars(List<Car> cars) {
        mCars = cars;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
