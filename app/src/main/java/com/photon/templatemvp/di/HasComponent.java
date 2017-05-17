package com.photon.templatemvp.di;

/**
 * Created by jumbada on 03/05/2017.
 */

/**
 * Interface representing a contract for clients that contains a component for dependency injection.
 */
public interface HasComponent<C> {
    C getComponent();
}
