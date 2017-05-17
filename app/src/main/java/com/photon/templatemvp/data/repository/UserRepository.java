package com.photon.templatemvp.data.repository;

import  com.photon.templatemvp.data.model.User;

import java.util.List;

import io.reactivex.Observable;
/**
 * Created by jumbada on 11/05/2017.
 */

/**
 * Interface that represents a Repository for getting {@link com.photon.templatemvp.data.model.User} related data.
 */
public interface UserRepository {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link  com.photon.templatemvp.data.model.User}.
     */
    Observable<List<User>> users();

    /**
     * Get an {@link rx.Observable} which will emit a {@link  com.photon.templatemvp.data.model.User}.
     *
     * @param userId The user id used to retrieve user data.
     */
    Observable<User> user(final int userId);
}