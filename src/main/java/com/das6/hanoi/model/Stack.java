package com.das6.hanoi.model;

import java.util.ArrayList;

public class Stack<T> implements IStack<T> {
    private ArrayList<T> stack;
    private int size;

    private final int MAX_SIZE;

    public Stack(int size) {
        this.stack = new ArrayList<>(size);
        this.MAX_SIZE = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    @Override
    public void push(T item) throws NullPointerException, IndexOutOfBoundsException{
        if(isNull(item)) {
            throw new NullPointerException();
        }
        if(isFull()) {
            throw new IndexOutOfBoundsException();
        }
        stack.add(item);
        size++;
    }

    @Override
    public T pop() throws IndexOutOfBoundsException {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        T item = stack.remove(size - 1);
        size--;
        return item;
    }

    private boolean isNull(T item) {
        return item == null;
    }
}
