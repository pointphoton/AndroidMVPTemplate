package com.photon.templatemvp.exception;

/**
 * Created by jumbada on 03/05/2017.
 */

/**
 * Exception throw by the application when a there is a network connection exception.
 */
public class NetworkConnectionException extends Exception {

    public NetworkConnectionException() {
        super();
    }

    public NetworkConnectionException(final String message) {
        super(message);

    }
    public NetworkConnectionException(final Throwable cause) {
        super(cause);
    }
}
