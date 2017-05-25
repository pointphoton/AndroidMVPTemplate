package com.photon.templatemvp.data.remote;

import android.support.annotation.Nullable;

import com.photon.templatemvp.exception.NetworkServiceException;
import com.photon.templatemvp.exception.ServiceErrorGenerator;
import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.util.Utils;

import java.util.Collection;
import java.util.concurrent.Callable;

import retrofit2.Response;


public final class ServiceResponse {


    private ServiceResponse() {
    }

    private interface ServicableResponse<T> {

        @Nullable
        T requestSyncCall() throws Exception;
        void checkResponse() throws Exception;

    }

    static class ModelObjectResponse<T> implements Callable<T>, ServicableResponse<T> {

        private Response<T> response;
        private T model;

        private ModelObjectResponse(Response<T> response) {
            this.response = response;
        }

        @SuppressWarnings("unchecked")
        static <T> ModelObjectResponse build(final Response<T> response) {
            return new ModelObjectResponse(response);
        }

        @Override
        public void checkResponse() throws Exception {
            Utils.checkNotNull(this.response);
            DebugLog.write("message :" + response.message());
            DebugLog.write("code :" + response.code());
            DebugLog.write("isSuccessful :" + response.isSuccessful());
            if (response.isSuccessful()) {
                model = response.body();
            } else {
                if (ServiceError.isClientError(response.code())) {
                    throw new NetworkServiceException(true, ServiceErrorGenerator
                            .CLIENT_ERROR_MESSAGE, new Throwable(ServiceErrorGenerator
                            .CLIENT_ERROR_MESSAGE));
                } else if (ServiceError.isServerError(response.code())) {
                    throw new NetworkServiceException(true, ServiceErrorGenerator
                            .SERVER_ERROR_MESSAGE, new Throwable(ServiceErrorGenerator
                            .SERVER_ERROR_MESSAGE));
                } else {
                    throw new NetworkServiceException(true, ServiceErrorGenerator
                            .UNDEFINED_ERROR_MESSAGE, new Throwable(ServiceErrorGenerator
                            .UNDEFINED_ERROR_MESSAGE));
                }

            }


        }

        @Nullable
        public T requestSyncCall() throws Exception {
            checkResponse();
            return model;
        }


        @Override
        public T call() throws Exception {
            return requestSyncCall();
        }
    }

    static class CollectionObjectResponse<T> implements Callable<Collection<T>>,
            ServicableResponse<T> {

        private Response<T> response;
        private T model;

        private CollectionObjectResponse(Response<T> response) {
            this.response = response;
        }

        @SuppressWarnings("unchecked")
        static <T> CollectionObjectResponse build(final Response<T> response) {
            return new CollectionObjectResponse(response);
        }

        @Override
        public void checkResponse() throws Exception {
            Utils.checkNotNull(this.response);
            DebugLog.write("message :" + response.message());
            DebugLog.write("code :" + response.code());
            DebugLog.write("isSuccessful :" + response.isSuccessful());
            if (response.isSuccessful()) {
                model = response.body();
            } else {
                if (ServiceError.isClientError(response.code())) {
                    throw new NetworkServiceException(true, ServiceErrorGenerator
                            .CLIENT_ERROR_MESSAGE, new Throwable(ServiceErrorGenerator
                            .CLIENT_ERROR_MESSAGE));
                } else if (ServiceError.isServerError(response.code())) {
                    throw new NetworkServiceException(true, ServiceErrorGenerator
                            .SERVER_ERROR_MESSAGE, new Throwable(ServiceErrorGenerator
                            .SERVER_ERROR_MESSAGE));
                } else {
                    throw new NetworkServiceException(true, ServiceErrorGenerator
                            .UNDEFINED_ERROR_MESSAGE, new Throwable(ServiceErrorGenerator
                            .UNDEFINED_ERROR_MESSAGE));
                }

            }


        }

        @Nullable
        public T requestSyncCall() throws Exception {
            checkResponse();
            return model;
        }

        @Override
        public Collection<T> call() throws Exception {
            return null;
        }


    }
}
