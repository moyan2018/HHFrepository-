package com.pengfei.framework.okhttp;

import okhttp3.Response;

public interface IOKHttpCallback {

    void callback(Response response) throws Exception;

}
