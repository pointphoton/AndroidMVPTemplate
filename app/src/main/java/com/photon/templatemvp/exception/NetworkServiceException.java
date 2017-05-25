package com.photon.templatemvp.exception;


/**
 * Exception throw by the application when a there is a Network Service Exception exception.
 */


public class NetworkServiceException extends Exception {


    private boolean willBeShown;


    private NetworkServiceException() {
        super();
    }

     /**
     * Create a custom {@link Exception} object to manage both exceptions and error messages shown in user in the views.
     * @param willBeShown determines whether a massage will be shown on UI or won't.
     * @param message    a String will be shown to the UI.
     * @param cause the exception message to be used for logging.

     */
    public NetworkServiceException(boolean willBeShown , final String message, final Throwable cause) {
        super(message,cause);
        setWillBeShown(willBeShown);

    }

    public boolean isWillBeShown() {
        return willBeShown;
    }
    private void setWillBeShown(boolean willBeShown){
        this.willBeShown = willBeShown;
    }


}
