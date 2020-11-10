package com.github.viniciusfcf.quarkus;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logavel
@Priority(1)
@Interceptor
public class LogavelInterceptor {

    @AroundInvoke
    public Object around(InvocationContext context) throws Exception {
        System.out.println("LogavelInterceptor.around()");
        return context.proceed();
    }
}