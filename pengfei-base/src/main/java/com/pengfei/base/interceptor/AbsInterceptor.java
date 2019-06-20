package com.pengfei.base.interceptor;

import com.pengfei.utils.dateTime.DateTimeUtils;
import com.pengfei.utils.json.JsonUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

public abstract class AbsInterceptor {

    public abstract void pointcut();

    protected void before(Object target, String targetClass, Method method, String methodName, Object[] args) throws Exception{
        System.out.println( String.format("【%s】 - %s:%s(%s)", DateTimeUtils.format(null, "yyyy-MM-dd HH:mm:ss.sss"), targetClass, methodName, JsonUtils.toJson(args)) );
    }

    protected void after(Object target, String targetClass, Method method, String methodName, Object[] args, Object result) throws Exception{
        System.out.println( String.format("【%s】 - %s:%s(%s) \r\n Info:{%s}", DateTimeUtils.format(null, "yyyy-MM-dd HH:mm:ss.sss"), targetClass, methodName, JsonUtils.toJson(args), JsonUtils.toJson(result)) );
    }

    protected void exception(Object target, String targetClass, Method method, String methodName, Object[] args, Throwable throwable) throws Throwable{
        System.out.println( String.format("【%s】 - %s:%s(%s) \r\n Error:{%s}", DateTimeUtils.format(null, "yyyy-MM-dd HH:mm:ss.sss"), targetClass, methodName, JsonUtils.toJson(args), JsonUtils.toJson(throwable.getMessage())) );
        throw throwable;
    }

    protected Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object target = proceedingJoinPoint.getTarget();
        String targetClass = target.getClass().getName();
        Method method = getMethod(proceedingJoinPoint);
        String methodName = method.getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = null;
        try {
            // 前值方法运行
            this.before(target, targetClass, method, methodName, args);
            // 方法执行
            result = proceedingJoinPoint.proceed();
            // 后置方法运行
            this.after(target, targetClass, method, methodName, args, result);
            return result;
        } catch (Throwable throwable){
            exception(target, targetClass, method, methodName, args, throwable);
            return result;
        }
    }

    protected Method getMethod(ProceedingJoinPoint proceedingJoinPoint){
        Signature s = proceedingJoinPoint.getSignature();
        MethodSignature ms = (MethodSignature)s;
        return ms.getMethod();
    }

}
