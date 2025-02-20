package com.das6.hanoi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hanoi {
    private int nDisks;
    private int nTowers;
    private List<Tower> towers;

    public Hanoi(int nD, int nT, int start) {
        this.nDisks = nD;
        this.nTowers = nT;
        this.towers = new ArrayList<>();
        for(int j = 0; j < nT; j++) {
            if(j == (start - 1)) {
                towers.add(new Tower(j, nD,IntStream.range(0, nDisks).map(i -> nDisks - i).boxed().collect(Collectors.toList())));
                continue;
            }
            towers.add(new Tower(j,nD));
        }
    }

    public void makeMove(Move move) {
        Tower fromTower = towers.get(move.fromTower() - 1);
        Tower toTower = towers.get(move.toTower() - 1);
        toTower.push(fromTower.pop());
    }

    public int getNumberDisks() {
        return nDisks;
    }

    public int getNumberTowers() {
        return nTowers;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public Tower getTower(int index) {
        return towers.get(index);
    }
}
