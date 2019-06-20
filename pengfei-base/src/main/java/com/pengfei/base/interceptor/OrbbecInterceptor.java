package com.pengfei.base.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Aspect
@Component
public class OrbbecInterceptor extends AbsInterceptor{

    @PostConstruct
    public void init(){
        System.out.println("*************************************************************************");
        System.out.println();
        System.out.println(String.format("                            spring aop(%s) init start                 ", OrbbecInterceptor.class.getSimpleName()));
        System.out.println();
        System.out.println("*************************************************************************");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return super.around(proceedingJoinPoint);
    }

    @Pointcut(value = "execution(public * com.pengfei.*.controller..*.*(..))")
    public void pointcut() {

    }
}
