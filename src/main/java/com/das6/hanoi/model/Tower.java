package com.das6.hanoi.model;

import java.util.*;

public class Tower implements IStack<Integer>{
    private int towerId;
    private List<Integer> disks;
    private List<Integer> publicDisks;
    private int maxStackSize;
    private int stackSize;

    public Tower(int towerId, int size, Set<Integer> disks) {
        this.towerId = towerId;
        this.disks = new LinkedList<>(disks);
        this.publicDisks = Collections.unmodifiableList(this.disks);
        this.maxStackSize = size;
        if(!disks.isEmpty()) {
            this.stackSize = this.disks.size();
        }else{
            this.stackSize = 0;
        }
    }

    public Tower(int towerId, int size) {
        this(towerId, size, Collections.emptySet());
    }

    private boolean isNull(Object n) {
        return n == null;
    }

    public int getTowerId() {
        return towerId;
    }

    public List<Integer> getDisks() {
        return publicDisks;
    }

    @Override
    public boolean isEmpty() {
        return stackSize == 0;
    }

    @Override
    public boolean isFull() {
        return stackSize == maxStackSize;
    }

    @Override
    public void push(Integer disk) throws NullPointerException, IndexOutOfBoundsException{
        if(isNull(disk)) {
            throw new NullPointerException();
        }
        if(isFull()) {
            throw new IndexOutOfBoundsException();
        }
        disks.add(disk);
        stackSize++;
    }

    @Override
    public Integer pop() {
        if(isEmpty()) {
            throw new NullPointerException();
        }
        Integer disk = disks.remove(stackSize - 1);
        stackSize--;
        return disk;
    }

    @Override
    public int size() {
        return stackSize;
    }
}
