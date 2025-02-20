package com.das6.hanoi.model;

public record Move(int fromTower, int toTower) {
    @Override
    public String toString() {
        return fromTower + " -> " + toTower + "\n";
    }
}
