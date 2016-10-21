package com.github.mvollebregt.wildmock.implementation.base;

import com.github.mvollebregt.wildmock.api.MethodCall;

import java.lang.reflect.Method;
import java.util.List;

public interface CallInterceptor {

    List<MethodCall> getRecordedCalls();

    Object intercept(Object target, Method method, Object[] arguments);

}
