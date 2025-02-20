package com.das6.hanoi;

import com.das6.hanoi.controller.Solver;
import com.das6.hanoi.model.Hanoi;
import com.das6.hanoi.model.Move;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi(3, 3, 1);
        Solver sl = new Solver();
        for(Move move : sl.solve(3,3,1,3)) {
            hanoi.makeMove(move);
            System.out.println(move);
            outputHanoi(hanoi);
        }
        Set<Integer> list = IntStream.range(0, 10).map(i -> 10 - i).boxed().collect(Collectors.toSet());
        System.out.println(list);
    }

    public static void outputHanoi(Hanoi hanoi) {
        hanoi.getTowers().forEach((tower) -> {
            System.out.println(tower.getTowerId() + " : " + tower.getDisks());
        });
        System.out.println("-------------------");
    }
}
