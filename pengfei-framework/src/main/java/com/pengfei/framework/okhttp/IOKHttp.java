package com.pengfei.framework.okhttp;


import okhttp3.Response;

public interface IOKHttp {

    IOKHttp addForm(String key, String value) throws Exception;

    IOKHttp addHeader(String key, String value) throws Exception;

    IOKHttp addFile(String fileName, EnMediaType enMediaType) throws Exception;

    IOKHttp createBody(String requestBody) throws Exception;

    IOKHttp createBody(String requestBody, EnMediaType enMediaType) throws Exception;

    IOKHttp createFormBody() throws Exception;

    IOKHttp createMultipartBody() throws Exception;

    void get(IOKHttpCallback callback) throws Exception;

    Response get() throws Exception;

    void post(IOKHttpCallback callback) throws Exception;

    Response post() throws Exception;

    void put(IOKHttpCallback callback) throws Exception;

    Response put() throws Exception;

    void delete(IOKHttpCallback callback) throws Exception;

    Response delete() throws Exception;

    Response getResponse() throws Exception;
}
