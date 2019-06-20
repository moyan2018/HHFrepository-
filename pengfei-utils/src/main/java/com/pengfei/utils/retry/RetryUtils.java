package com.pengfei.utils.retry;

import com.pengfei.framework.retry.IRetryException;
import com.pengfei.framework.retry.IRetryTimes;
import com.pengfei.framework.retry.RetryManager;

public final class RetryUtils {

    private RetryUtils() {

    }

    public static void retryVoid(IRetryTimes<Boolean> retryTimes, int times) throws Exception{
        RetryManager.retry(retryTimes, times, 0);
    }

    public static <Target> Target retry(IRetryTimes<Target> retryTimes, int times) throws Exception{
        return RetryManager.retry(retryTimes, times, 0);
    }

    public static void retryVoid(IRetryTimes<Boolean> retryTimes, int times, long sleepTime) throws Exception{
        RetryManager.retry(retryTimes, times, sleepTime);
    }

    public static <Target> Target retry(IRetryTimes<Target> retryTimes, int times, long sleepTime) throws Exception{
        return RetryManager.retry(retryTimes, times, sleepTime);
    }

    public static void retryVoid(IRetryException<Boolean> retryException) throws Exception{
        RetryManager.retry(retryException);
    }

    public static <Target> Target retry(IRetryException<Target> retryException) throws Exception{
        return RetryManager.retry(retryException);
    }

    public static void retryVoid(IRetryException<Boolean> retryException, int times) throws Exception{
        RetryManager.retry(retryException, times, 0);
    }

    public static <Target> Target retry(IRetryException<Target> retryException, int times) throws Exception{
        return RetryManager.retry(retryException, times, 0);
    }

    public static void retryVoid(IRetryException<Boolean> retryException, int times, long sleepTime) throws Exception{
        RetryManager.retry(retryException, times, sleepTime);
    }

    public static <Target> Target retry(IRetryException<Target> retryException, int times, long sleepTime) throws Exception{
        return RetryManager.retry(retryException, times, sleepTime);
    }

}
