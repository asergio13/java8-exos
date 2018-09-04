package com.serge.abousaleh.functional;

@FunctionalInterface
public interface MyGeneric<T> {
	T compute(T t);
}
