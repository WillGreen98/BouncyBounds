package org.bgw.bouncybounds.shapes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.bgw.bouncybounds.model.Shape;
import org.bgw.bouncybounds.model.ShapeColor;

public class Ball implements Shape {
    private final Circle circle;
    private double dx; // Horizontal speed
    private double dy; // Vertical speed

    public Ball(double centerX, double centerY, double radius, Color color, double speedX, double speedY) {
        circle = new Circle(centerX);
        circle.setFill(ShapeColor.getRandomColor());
        dx = speedX;
        dy = speedY;
    }

    @Override
    public void setX(double x) {
        circle.setCenterX(x);
    }

    @Override
    public void setY(double y) {
        circle.setCenterY(y);
    }

    @Override
    public double getX() {
        return circle.getCenterX();
    }

    @Override
    public double getY() {
        return circle.getCenterY();
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    @Override
    public void move(double deltaX, double deltaY) {
        double newX = getX() + deltaX;
        double newY = getY() + deltaY;

        setX(newX);
        setY(newY);
    }

    @Override
    public void handleCollisionSameShape(Shape otherBall) {
        System.out.println("Circle hit another circle");
    }

    @Override
    public void handleCollisionDifferentShape(Shape otherShape) {
        System.out.println("Circle hit another Shape");
        // TODO: Implement collision handling logic specific to Ball and other shapes
        // For example, you might check the type of the other shape and react accordingly
    }

    @Override
    public void handleCollisionBorder(double paneWidth, double paneHeight) {
        double minX = getX() - getBoundingWidth(); // Leftmost x-coordinate of the circle
        double minY = getY() - getBoundingWidth(); // Topmost y-coordinate of the circle
        double maxX = getX() + getBoundingWidth(); // Rightmost x-coordinate of the circle
        double maxY = getY() + getBoundingWidth(); // Bottommost y-coordinate of the circle

        if (minX <= 0 || maxX >= paneWidth) {
            // Handle collision with left or right border
            dx *= -1; // Reverse horizontal velocity
        }
        if (minY <= 0 || maxY >= paneHeight) {
            // Handle collision with top or bottom border
            dy *= -1; // Reverse vertical velocity
        }
    }

    @Override
    public double getBoundingWidth() {
        return circle.getRadius() * 2;
    }

    @Override
    public double getBoundingHeight() {
        return circle.getRadius() * 2;
    }

    @Override
    public Shape returnShape() {
        return (Shape) circle;
    }

    @Override
    public void updatePosition(double elapsedTime, double paneWidth, double paneHeight) {
        double newX = getX() + dx * elapsedTime;
        double newY = getY() + dy * elapsedTime;

        // Ensure that the circle stays within the bounds of the shapesPane
        double radius = getBoundingHeight();
        newX = Math.max(radius, Math.min(newX, paneWidth - radius));
        newY = Math.max(radius, Math.min(newY, paneHeight - radius));

        // Update the position of the circle
        setX(newX);
        setY(newY);
    }

    @Override
    public void initialise(Pane pane) {
        pane.getChildren().add(circle);
    }
}