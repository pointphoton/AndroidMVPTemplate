package com.photon.templatemvp.data.repository;

/**
 * Created by jumbada on 11/05/2017.
 */


import com.photon.templatemvp.data.entity.mapper.UserEntityDataMapper;
import com.photon.templatemvp.data.model.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link UserRepository} for retrieving user data.
 */
@Singleton
public class UserDataRepository implements UserRepository {

    private final UserDataStoreFactory userDataStoreFactory;
    private final UserEntityDataMapper userEntityDataMapper;

    /**
     * Constructs a {@link UserRepository}.
     *
     * @param dataStoreFactory A factory to construct different data source implementations.
     * @param userEntityDataMapper {@link UserEntityDataMapper}.
     */
    @Inject
    UserDataRepository(UserDataStoreFactory dataStoreFactory,
                       UserEntityDataMapper userEntityDataMapper) {
        this.userDataStoreFactory = dataStoreFactory;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @Override
    public Observable<List<User>> users() {
        /*
        //we always get all users from the cloud
        final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        return userDataStore.userEntityList().map(this.userEntityDataMapper::transform);
        */
        return null;
    }

    @Override
    public Observable<User> user(int userId) {
        /*
        Log.d("UserDataRepository","this.userDataStoreFactory.create(userId)");
        final UserDataStore userDataStore = this.userDataStoreFactory.create(userId);
        return userDataStore.userEntityDetails(userId).map(this.userEntityDataMapper::transform);
        */
        return null;
    }
}