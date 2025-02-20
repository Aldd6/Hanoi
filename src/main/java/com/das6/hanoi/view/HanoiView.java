package com.das6.hanoi.view;

import com.das6.hanoi.model.Tower;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.ArrayList;

import com.das6.hanoi.model.Hanoi;

public class HanoiView extends HBox{

    private List<TowerView> towerViews;

    public HanoiView() {
        this.setSpacing(10);
        this.setFillHeight(true);
        this.setBackground(Background.fill(Color.SKYBLUE));
        towerViews = new ArrayList<>();
    }

    public void renderHanoi(Hanoi hanoi) {
        int nDisks = hanoi.getNumberDisks();
        int nTowers = towerViews.size();
        System.out.println(nDisks);
        towerViews.clear();
        System.out.println(towerViews);
        hanoi.getTowers().forEach((tower) -> {
            towerViews.add(createTowerView(nDisks));
            System.out.println("Tower added!");
        });
        System.out.println(towerViews.size());
        for(int i = 0; i < nTowers; i++) {
            towerViews.get(i).renderTower(hanoi.getTower(i));
            System.out.println("disk added!");
        }
        this.getChildren().setAll(towerViews);
        this.requestLayout();
    }

    private TowerView createTowerView(int nDisks) {
        TowerView view = new TowerView(nDisks);
        setHgrow(view, Priority.ALWAYS);
        return view;
    }
}
