package com.photon.templatemvp.data.remote;

/**
 * Created by jumbada on 23/05/2017.
 */

public interface RemoteConstant {

     static final String BASE_URL = "http://www.mocky.io";
     static final String CONTENT_TYPE_LABEL = "Content-Type";
     static final String CONTENT_TYPE_VALUE_JSON = "application/json; charset=utf-8";
     static final String HTTP_CACHE_PATH = "http-cache";
     static final long CONNECTION_TIMEOUT = 15L;
     static final long READ_TIMEOUT = 10L;
     static final long CACHE_SIZE = 10*1024*1024;
}
