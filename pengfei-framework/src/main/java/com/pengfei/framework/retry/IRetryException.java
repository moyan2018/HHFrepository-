package com.pengfei.framework.retry;

public interface IRetryException<Target> {

    Target retry() throws Exception;

    boolean isRetry(Exception exception);

}
