package com.das6.hanoi.controller;

import com.das6.hanoi.model.Hanoi;
import com.das6.hanoi.model.Move;

import java.util.LinkedList;
import java.util.List;

public class Solver {
    private int disks;
    private int towers;

    public Solver(int disks, int towers) {
        this.disks = disks;
        this.towers = towers;
    }

    public List<Move> solve(int fromT, int toT) {
        List<Move> moves = new LinkedList<>();
        return moves;
    }

    private void solver(List<Move> moves, int nD, int start, int end) {
        if(disks == 1) {
            moves.add(new Move(start, end));
        }else{
            int other = (towers * 2) - (start + end);
            solver(moves, disks - 1, start, other);
            moves.add(new Move(start, end));
            solver(moves, disks - 1, other, end);
        }
    }
}
