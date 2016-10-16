package com.github.mvollebregt.wildmock.function;

@FunctionalInterface
public interface FunctionA<A, R> extends VarargsFunction<R> {

    R apply(A a);

    @SuppressWarnings("unchecked")
    default R apply(Object... params) {
        return apply((A) params[0]);
    }
}
