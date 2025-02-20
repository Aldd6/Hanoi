package com.das6.hanoi.controller;

import com.das6.hanoi.model.Hanoi;
import com.das6.hanoi.model.Move;

import java.util.LinkedList;
import java.util.List;

public class Solver {

    public List<Move> solve(int nT, int nD, int start, int end) {
        List<Move> moves = new LinkedList<>();
        solver(moves, nT, nD, start, end);
        return moves;
    }

    private void solver(List<Move> moves, int nT, int nD, int start, int end) {
        if(nD == 1) {
            moves.add(new Move(start, end));
        }else{
            int other = (nT * 2) - (start + end);
            solver(moves, nT, nD - 1, start, other);
            moves.add(new Move(start, end));
            solver(moves, nT, nD - 1, other, end);
        }
    }
}
