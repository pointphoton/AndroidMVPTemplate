package com.photon.templatemvp.exception;

/**
 * Created by jumbada on 24/05/2017.
 */

/**
 * Exception throw by the application when a there is a test exception.
 */


public class TestException extends Exception {

    public TestException() {
        super();
    }


     /**
     * Create a custom {@link Exception} object to manage both exceptions and error messages shown in user in the views.
     *
     * @param message    a String will be shown to the UI.
     * @param cause the exception message to be used for logging.

     */
    public TestException(final String message,final Throwable cause) {
        super(message,cause);
    }
}
