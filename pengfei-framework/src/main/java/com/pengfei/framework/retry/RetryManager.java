package com.pengfei.framework.retry;

public final class RetryManager {

    private RetryManager() {

    }


    public static <Target> Target retry(IRetryTimes<Target> retryTimes, int times, long sleepTime) throws Exception{
        if( times <= 0 ) times = 3;
        Target target = null;
        Exception exception = null;
        for(int i = 0; i <= times; i++) {
            exception = null;
            try {
                target = retryTimes.retry();
                break;
            } catch (Exception e){
                exception = e;
                if(i > 0) {
                    System.out.println(String.format("***********************  Try [%s/%s] ***********************", i, times));
                }
            }
            if( sleepTime > 0 ) {
                Thread.sleep(sleepTime);
            }
        }
        if( exception != null ) {
            throw exception;
        }
        return target;
    }

    public static <Target> Target retry(IRetryException<Target> retryException) throws Exception{
        Target target = null;
        boolean isRetry;
        Exception exception = null;
        int times = 0;
        do {
            exception = null;
            try {
                target = retryException.retry();
                isRetry = false;
            } catch (Exception e) {
                exception = e;
                if( times > 0 ) {
                    System.out.println(String.format("***********************  Try [%s] ***********************", times));
                }
                isRetry = retryException.isRetry(e);
            }
        } while(isRetry);
        if( exception != null ) {
            throw exception;
        }
        return target;
    }

    public static <Target> Target retry(IRetryException<Target> retryException, int times, long sleepTime) throws Exception{
        if( times <= 0 ) times = 3;
        Target target = null;
        boolean isRetry;
        Exception exception = null;
        for(int i = 0; i <= times; i++) {
            exception = null;
            try {
                target = retryException.retry();
                isRetry = false;
            } catch (Exception e) {
                exception = e;
                if( i > 0 ) {
                    System.out.println(String.format("***********************  Try [%s/%s] ***********************", i, times));
                }
                isRetry = retryException.isRetry(e);
            }
            if( !isRetry ) {
                 break;
            }
            if( sleepTime > 0 ) {
                Thread.sleep(sleepTime);
            }
        }
        if( exception != null ) {
            throw exception;
        }
        return target;
    }
}
