package com.das6.hanoi.controller;

import com.das6.hanoi.model.Move;
import javafx.application.Application;

import com.das6.hanoi.model.Hanoi;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import com.das6.hanoi.view.HanoiView;

import java.util.List;

public class HanoiApp extends Application {
    private Hanoi hanoi;

    public HanoiApp() {}

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox controls = new HBox(5);
        controls.getChildren().add(new Label("Number of disks:"));
        Spinner<Integer> numDisksSpinner = new Spinner<Integer>(3,10,3);
        controls.getChildren().add(numDisksSpinner);
        controls.getChildren().add(new Label("Number of Towers:"));
        Spinner<Integer> numTowersSpinner = new Spinner<Integer>(3,10,3);
        controls.getChildren().add(numTowersSpinner);
        controls.getChildren().add(new Label("Start tower:"));
        TextField txtStartTower = new TextField();
        txtStartTower.setText("1");
        controls.getChildren().add(txtStartTower);
        controls.getChildren().add(new Label("End tower:"));
        TextField txtEndTower = new TextField();
        txtEndTower.setText("0");
        controls.getChildren().add(txtEndTower);
        Button solve = new Button("Solve");
        controls.getChildren().add(solve);

        HanoiView view = new HanoiView();
        hanoi = new Hanoi(numDisksSpinner.getValue(), numTowersSpinner.getValue(), Integer.parseInt(txtStartTower.getText()));
        view.renderHanoi(hanoi);

        numDisksSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            hanoi = new Hanoi(newValue, numTowersSpinner.getValue(), Integer.parseInt(txtStartTower.getText()));
            view.renderHanoi(hanoi);
        });

        numTowersSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            hanoi = new Hanoi(numDisksSpinner.getValue(), newValue, Integer.parseInt(txtStartTower.getText()));
            view.renderHanoi(hanoi);
        });

        solve.setOnAction(e -> {
            controls.setDisable(true);
            hanoi = new Hanoi(numDisksSpinner.getValue(), numTowersSpinner.getValue(), Integer.parseInt(txtStartTower.getText()));
            view.renderHanoi(hanoi);
            Solver solver = new Solver();
            List<Move> moves = solver.solve(
                    numTowersSpinner.getValue(),
                    numDisksSpinner.getValue(),
                    Integer.parseInt(txtStartTower.getText()),
                    Integer.parseInt(txtEndTower.getText())
            );
            Duration frameTime = Duration.seconds(0.5);
            Duration current = Duration.ZERO;
            Timeline timeline = new Timeline();
            for(Move move : moves) {
                current = current.add(frameTime);
                KeyFrame keyFrame = new KeyFrame(current, evt -> {
                    hanoi.makeMove(move);
                    view.renderHanoi(hanoi);
                });
                timeline.getKeyFrames().add(keyFrame);
            }
            timeline.setOnFinished(evt -> controls.setDisable(false));
            timeline.play();
        });

        BorderPane root = new BorderPane();
        root.setTop(controls);
        root.setCenter(view);
        Scene scene = new Scene(root, 1080, 720);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hanoi");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
