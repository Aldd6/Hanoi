package com.das6.hanoi.model;

import java.util.ArrayList;
import java.util.List;

public class Hanoi {
    private int nDisks;
    private int nTowers;
    private List<Tower> towers;

    public Hanoi(int nD, int nT) {
        this.nDisks = nD;
        this.nTowers = nT;
        this.towers = new ArrayList<>();
        for(int i = 0; i < nT; i++) {
            towers.add(new Tower(i,nD));
        }
    }

    public void makeMove(int fromT, int toT) {
        Tower fromTower = towers.get(fromT - 1);
        Tower toTower = towers.get(toT - 1);
        toTower.push(fromTower.pop());
    }

    public int getNumberDisks() {
        return nDisks;
    }

    public int getNumberTowers() {
        return nTowers;
    }
}
