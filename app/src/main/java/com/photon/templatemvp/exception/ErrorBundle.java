package com.photon.templatemvp.exception;

/**
 * Created by jumbada on 03/05/2017.
 */

/**
 * Interface to represent a wrapper around an {@link Exception} to manage errors.
 */
public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
