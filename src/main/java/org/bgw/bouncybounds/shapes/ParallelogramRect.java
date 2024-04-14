package org.bgw.bouncybounds.shapes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.bgw.bouncybounds.model.Shape;

public class ParallelogramRect implements Shape{
    private final Rectangle rectangle;
    private double dx; // Horizontal speed
    private double dy; // Vertical speed

    public ParallelogramRect(double x, double y, double width, double height, Color color, double speedX, double speedY) {
        rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(color);
        dx = speedX;
        dy = speedY;
    }

    @Override
    public void setX(double x) {
        rectangle.setX(x);
    }

    @Override
    public void setY(double y) {
        rectangle.setY(y);
    }

    @Override
    public double getX() {
        return rectangle.getX();
    }

    @Override
    public double getY() {
        return rectangle.getY();
    }

    @Override
    public void setDx(double dx) {
        this.dx = dx;
    }

    @Override
    public void setDy(double dy) {
        this.dy = dy;
    }

    @Override
    public double getDx() {
        return dx;
    }

    @Override
    public double getDy() {
        return dy;
    }

    @Override
    public void move(double deltaX, double deltaY) {
        rectangle.setX(rectangle.getX() + deltaX);
        rectangle.setY(rectangle.getY() + deltaY);
    }

    @Override
    public void handleCollisionSameShape(Shape otherShape) {
        // Implementation for handling collisions with other shapes (not provided here)
    }

    @Override
    public void handleCollisionDifferentShape(Shape otherShape) {
        // Implement collision handling logic specific to Ball and other shapes
        // For example, you might check the type of the other shape and react accordingly
    }

    @Override
    public void handleCollisionBorder(double paneWidth, double paneHeight) {
        double newX = rectangle.getX();
        double newY = rectangle.getY();
        double width = rectangle.getWidth();
        double height = rectangle.getHeight();

        // Check for collisions with the edges
        if (newX <= 0 || newX + width >= paneWidth) {
            dx *= -1; // Reverse horizontal direction
        }
        if (newY <= 0 || newY + height >= paneHeight) {
            dy *= -1; // Reverse vertical direction
        }
    }

    @Override
    public double getBoundingWidth() {
        return rectangle.getWidth();
    }

    @Override
    public double getBoundingHeight() {
        return rectangle.getHeight();
    }

    @Override
    public Shape returnShape() {
        return (Shape) rectangle;
    }

    @Override
    public void updatePosition(double elapsedTime, double paneWidth, double paneHeight) {
        double newX = rectangle.getX() + dx * elapsedTime;
        double newY = rectangle.getY() + dy * elapsedTime;

        move(newX, newY);
    }

    @Override
    public void initialise(Pane pane) {
        pane.getChildren().add(rectangle);
    }
}
