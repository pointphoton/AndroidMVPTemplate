package com.photon.templatemvp.exception;

/**
 * Created by jumbada on 11/05/2017.
 */

import android.content.Context;

import com.photon.templatemvp.R;

/**
 * Factory used to create error messages from an Exception as a condition.
 */
public class ErrorMessageFactory {

    private ErrorMessageFactory() {
        //empty
    }

    /**
     * Creates a String representing an error message.
     *
     * @param context Context needed to retrieve string resources.
     * @param exception An exception used as a condition to retrieve the correct error message.
     * @return {@link String} an error message.
     */
    public static String create(Context context, Exception exception) {
     //  String message = context.getString(R.string.exception_message_generic);
        String message;

        if (exception instanceof NetworkConnectionException) {
          //  message = context.getString(R.string.exception_message_no_connection);
            message = exception.getMessage() == null ? "DEFAULT NetworkConnectionException ERROR " : exception.getMessage();
        } else if (exception instanceof UserNotFoundException) {
            message = context.getString(R.string.exception_message_user_not_found);
        }
        else {
            message =  exception.getMessage();
        }

        return message;
    }
}