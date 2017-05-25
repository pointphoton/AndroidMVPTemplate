package com.photon.templatemvp.exception;

/**
 * Created by jumbada on 25/05/2017.
 */

public class ServiceErrorGenerator {

    public static final String UNDEFINED_ERROR_MESSAGE = "Unknown  ServiceError";
    public static final String NO_NETWORK_MESSAGE = "There is no internet connection.";
    public static final String CLIENT_ERROR_MESSAGE =  "Client error. Please try again.";;
    public static final String SERVER_ERROR_MESSAGE = "Server error. Please try again.";


    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 400;


    private static final int GROUP_200 = 2;
    private static final int GROUP_400 = 4;
    private static final int GROUP_500 = 5;
    private static final int VALUE_100 = 100;

    public static boolean isSuccess(int responseCode) {
        return responseCode / VALUE_100 == GROUP_200;
    }

    public static boolean isClientError(int errorCode) {
        return errorCode / VALUE_100 == GROUP_400;
    }

    public static boolean isServerError(int errorCode) {
        return errorCode / VALUE_100 == GROUP_500;
    }

}
