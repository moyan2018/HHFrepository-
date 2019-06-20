package com.pengfei.framework.okhttp;

import com.pengfei.framework.FrameWorkCommon;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

class OKHttpImpl implements IOKHttp{

    private String url;
    private OkHttpClient okHttpClient;
    private Request request;
    private Response response_return;
    private Exception exception;
    private Call call;
    private Request.Builder requestBuilder;
    private RequestBody requestBody;
    private FormBody.Builder formBodyBuilder;
    private MultipartBody.Builder multipartBodyBuilder;

    public OKHttpImpl(String url){
        this.url = url;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS);
        builder.writeTimeout(60, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);
        okHttpClient = builder.build();
    }


    @Override
    public IOKHttp addForm(String key, String value) throws Exception {
        if( FrameWorkCommon.isEmpty(key) ) return this;
        if( FrameWorkCommon.isNotEmpty(this.formBodyBuilder) ){
            this.formBodyBuilder.add(key, value);
        }
        if( FrameWorkCommon.isNotEmpty(this.multipartBodyBuilder) ){
            this.multipartBodyBuilder.addFormDataPart(key, value);
        }
        return this;
    }

    @Override
    public IOKHttp addFile(String fileName, EnMediaType enMediaType) throws Exception {
        if( FrameWorkCommon.isEmpty(enMediaType) ) enMediaType = EnMediaType.getDefaultFile();
        if( FrameWorkCommon.isEmpty(this.multipartBodyBuilder) && FrameWorkCommon.isEmpty(this.requestBody) ){
            this.requestBody = RequestBody.create(MediaType.parse(enMediaType.getCode()) , new File(fileName));
        }
        return this;
    }

    @Override
    public IOKHttp addHeader(String key, String value) throws Exception {
        if( FrameWorkCommon.isEmpty(key) || FrameWorkCommon.isEmpty(value) ) return this;
        if(FrameWorkCommon.isEmpty(this.requestBuilder)){
            this.requestBuilder = new Request.Builder();
        }
        this.requestBuilder.addHeader(key, value);
        return this;
    }

    @Override
    public IOKHttp createBody(String requestBody) throws Exception {
        return createBody(requestBody, null);
    }

    @Override
    public IOKHttp createBody(String requestBody, EnMediaType enMediaType) throws Exception {
        if( FrameWorkCommon.isEmpty(requestBody) ) return this;
        if( FrameWorkCommon.isEmpty(enMediaType) ) enMediaType = EnMediaType.getDefaultString();
        this.requestBody = RequestBody.create( MediaType.parse(enMediaType.getCode()), requestBody);
        this.formBodyBuilder = null;
        this.multipartBodyBuilder = null;
        return this;
    }

    @Override
    public IOKHttp createFormBody() throws Exception {
        this.formBodyBuilder = new FormBody.Builder();
        this.requestBody = null;
        this.multipartBodyBuilder = null;
        return this;
    }

    @Override
    public IOKHttp createMultipartBody() throws Exception {
        this.multipartBodyBuilder = new MultipartBody.Builder();
        this.multipartBodyBuilder.setType(MultipartBody.FORM);
        this.requestBody = null;
        this.formBodyBuilder = null;
        return this;
    }

    @Override
    public void get(IOKHttpCallback callback) throws Exception {
        if( FrameWorkCommon.isEmpty(callback) ) return;
        createRequest(1);
        run(callback);
    }

    @Override
    public Response get() throws Exception {
        createRequest(1);
        run(null);
        System.out.println( this.response_return.body().string() );
        return this.response_return;
    }

    @Override
    public void post(IOKHttpCallback callback) throws Exception {
        if( FrameWorkCommon.isEmpty(callback) ) return;
        createRequest(2);
        run(callback);
    }

    @Override
    public Response post() throws Exception {
        createRequest(2);
        run(null);
        return this.response_return;
    }

    @Override
    public void put(IOKHttpCallback callback) throws Exception {
        if( FrameWorkCommon.isEmpty(callback) ) return;
        createRequest(3);
        run(callback);
    }

    @Override
    public Response put() throws Exception {
        createRequest(3);
        run(null);
        return this.response_return;
    }

    @Override
    public void delete(IOKHttpCallback callback) throws Exception {
        if( FrameWorkCommon.isEmpty(callback) ) return;
        createRequest(4);
        run(callback);
    }

    @Override
    public Response delete() throws Exception {
        createRequest(4);
        run(null);
        return this.response_return;
    }

    private void createRequest(int type) throws Exception {
        if( FrameWorkCommon.isEmpty(this.requestBuilder) ) {
            this.requestBuilder = new Request.Builder();
        }
        this.requestBuilder.url(url);
        if( FrameWorkCommon.isNotEmpty(this.formBodyBuilder) ){
            this.requestBody = this.formBodyBuilder.build();
        }
        if( FrameWorkCommon.isNotEmpty(this.multipartBodyBuilder) ){
            this.requestBody = this.multipartBodyBuilder.build();
        }
        if( type == 1 ) {
            this.request = this.requestBuilder.get().build();
        } else if( type == 2 ) {
            this.request = this.requestBuilder.post(this.requestBody).build();
        } else if( type == 3 ) {
            this.request = this.requestBuilder.put(this.requestBody).build();
        } else if( type == 4 ) {
            if( FrameWorkCommon.isEmpty(this.requestBody) ){
                this.request = this.requestBuilder.delete().build();
            } else {
                this.request = this.requestBuilder.delete(this.requestBody).build();
            }
        }
    }

    private void run(IOKHttpCallback callback) throws Exception {
        exception = null;
        this.call = this.okHttpClient.newCall(this.request);
        System.out.println(String.format("【ok http request url】 -> %s", this.url));
        if( FrameWorkCommon.isEmpty(callback) ){
            response_return = call.execute();
        } else {
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    response_return = response;
                    try {
                        callback.callback(response_return);
                    } catch (Exception e) {
                        throw new IOException(e.getMessage());
                    }
                }
            });
        }
    }

    @Override
    public Response getResponse() throws Exception {
        return this.response_return;
    }
}
