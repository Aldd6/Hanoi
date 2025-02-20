package com.das6.hanoi.view;

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
        towerViews.clear();
        hanoi.getTowers().forEach((tower) -> {
            towerViews.add(createTowerView(nDisks));
        });
        for(int i = 0; i < nDisks; i++) {
            towerViews.get(i).renderTower(hanoi.getTower(i));
        }
        this.getChildren().setAll(towerViews);
    }

    private TowerView createTowerView(int nDisks) {
        TowerView view = new TowerView(nDisks);
        setHgrow(view, Priority.ALWAYS);
        return view;
    }
}
