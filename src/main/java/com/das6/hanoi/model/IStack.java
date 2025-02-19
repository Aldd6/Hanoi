package com.das6.hanoi.model;

import java.lang.NullPointerException;
import java.lang.IndexOutOfBoundsException;

public interface IStack<T> {
    void push(T item) throws NullPointerException, IndexOutOfBoundsException;
    T pop() throws IndexOutOfBoundsException;
    boolean isEmpty();
    boolean isFull();
    int size();
}
