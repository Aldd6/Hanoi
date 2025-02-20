package com.das6.hanoi.view;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import com.das6.hanoi.model.Tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TowerView extends Region {

    private final int totalTowerDisks;
    private final Rectangle stem = new Rectangle();
    private final List<Integer> diskIndexes = new ArrayList<>();
    private final List<Rectangle> disks = new ArrayList<>();

    private static final double STEM_WIDTH = 10;

    public TowerView(int totalTowerDisks) {
        this.totalTowerDisks = totalTowerDisks;
        stem.setFill(Color.SADDLEBROWN);
        this.getChildren().add(stem);
    }

    @Override
    protected void layoutChildren() {
        double leftEdge = this.snappedLeftInset();
        double rightEdge = this.snappedRightInset();
        double availableWidth = this.getWidth() - leftEdge - rightEdge;
        double topEdge = this.snappedTopInset();
        double bottomEdge = this.snappedBottomInset();
        double availableHeight = this.getHeight() - topEdge - bottomEdge;
        stem.setWidth(STEM_WIDTH);
        stem.setX(leftEdge + availableWidth / 2 - STEM_WIDTH / 2);
        stem.setY(topEdge);
        stem.setHeight(availableHeight);

        int nDisks = diskIndexes.size();
        for(int i = 0; i < nDisks; i++) {
            int relWidth = diskIndexes.get(i);
            Rectangle disk  = disks.get(i);
            double diskWidth = availableWidth * relWidth / totalTowerDisks;
            disk.setWidth(diskWidth);
            disk.setHeight(availableHeight / totalTowerDisks);
            disk.setX(leftEdge + availableWidth / 2 - diskWidth / 2);
            disk.setY(topEdge + availableHeight - (availableHeight * (nDisks - i)) / totalTowerDisks);
        }
    }

    public void renderTower(Tower tower) {
        diskIndexes.clear();
        diskIndexes.addAll(tower.getDisks());

        Collections.reverse(diskIndexes);

        this.getChildren().setAll(stem);
        disks.clear();
        diskIndexes.forEach((index) -> {
            Rectangle disk = new Rectangle();
            disk.setFill(getColor(index));
            double arc = 25.0;
            disk.setArcWidth(arc);
            disk.setArcHeight(arc);
            disks.add(disk);
            this.getChildren().add(disk);
        });
    }

    private Color getColor(int index) {
        return Color.gray(1.0 - 1.0 * index / totalTowerDisks);
    }
}
