package com.pengfei.framework.retry;

public interface IRetryTimes<Target> {

    Target retry() throws Exception;

}
