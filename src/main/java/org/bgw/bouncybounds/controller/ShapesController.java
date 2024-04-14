package org.bgw.bouncybounds.controller;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.bgw.bouncybounds.model.Shape;
import org.bgw.bouncybounds.model.ShapeColor;
import org.bgw.bouncybounds.shapes.Ball;

import java.util.ArrayList;
import java.util.List;

public class ShapesController {
    @FXML
    private AnchorPane shapesPane;

    private final List<Shape> shapes = new ArrayList<>();

    public void initialize() {
        Ball ball = new Ball(20, 20, 1, ShapeColor.getRandomColor(), 10, 15);
        ball.initialise(shapesPane);

        shapes.add(ball);

        handleAnimation();
    }

    private void handleAnimation() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                shapes.forEach(shape -> {
                    shape.updatePosition(1, shapesPane.getWidth(), shapesPane.getHeight()); // Pass a constant value for elapsed time for simplicity
                    shape.handleCollisionBorder(shapesPane.getWidth(), shapesPane.getHeight());
                });
            }
        };

        timer.start();
    }
}
