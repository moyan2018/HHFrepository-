package com.pengfei.base.wrapper;

import org.apache.poi.util.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

public class BodyCachingHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private byte[] body;
    private ServletInputStreamWrapper inputStreamWrapper;

    public BodyCachingHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        this.body = IOUtils.toByteArray(request.getInputStream());
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.body);
        this.inputStreamWrapper = new ServletInputStreamWrapper(byteArrayInputStream);
        resetInputStream();
    }

    private void resetInputStream() {
        this.inputStreamWrapper.setInputStream(new ByteArrayInputStream(this.body != null ? this.body : new byte[0]));
    }

    public byte[] getBody() {
        return body;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return this.inputStreamWrapper;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.inputStreamWrapper));
    }

    private static class ServletInputStreamWrapper extends ServletInputStream {

        private InputStream inputStream;

        private ServletInputStreamWrapper(InputStream inputStream){
            this.inputStream = inputStream;
        }

        public InputStream getInputStream() {
            return inputStream;
        }

        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public boolean isFinished() {
            return true;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener readListener) {

        }

        @Override
        public int read() throws IOException {
            return this.inputStream.read();
        }
    }

}
