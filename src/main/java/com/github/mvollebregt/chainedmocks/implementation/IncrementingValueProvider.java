package com.github.mvollebregt.chainedmocks.implementation;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

class IncrementingValueProvider implements ValueProvider {

    private static final long INITIAL_SEED = 19760713;

    private final Objenesis objenesis = new ObjenesisStd();

    private long seed;

    IncrementingValueProvider() {
        this.seed = INITIAL_SEED;
    }

    @Override
    public Object provide(Class type) {
        seed++;
        if (type.equals(Byte.TYPE)) {
            return (byte) seed;
        } else if (type.equals(Short.TYPE) || type.equals(Short.class)) {
            return (short) seed;
        } else if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {
            return (int) seed;
        } else if (type.equals(Long.TYPE) || type.equals(Long.class)) {
            return seed;
        } else if (type.equals(Float.TYPE) || type.equals(Float.class)) {
            return (float) seed;
        } else if (type.equals(Double.TYPE) || type.equals(Double.class)) {
            return (double) seed;
        } else if (type.equals(Boolean.TYPE) || type.equals(Boolean.class)) {
            return seed % 2 == 0;
        } else if (type.equals(Character.TYPE) || type.equals(Character.class)) {
            return (char) seed;
        } else if (type.equals(String.class)) {
            return String.valueOf(seed);
        } else if (type.equals(Void.TYPE)) {
            return null;
        } else {
            return objenesis.newInstance(type);
        }
    }
}
