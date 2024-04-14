package org.bgw.bouncybounds.model;

import javafx.scene.layout.Pane;

public interface Shape extends Collidable {
    void setX(double x);
    void setY(double y);

    double getX();
    double getY();

    void setDx(double dx);

    void setDy(double dy);

    double getDx();

    double getDy();

    // Method to move the shape by a specified amount
    public default void move(double deltaX, double deltaY) {
        // Adjust the position of the shape's center
        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }

    // Methods for handling collisions with other shapes and the pane border
    void handleCollisionSameShape(Shape otherShape);
    void handleCollisionDifferentShape(Shape otherShape);
    void handleCollisionBorder(double paneWidth, double paneHeight);

    // Methods for getting bounding width and height
    double getBoundingWidth();
    double getBoundingHeight();

    // Method to initialize the shape and add it to a pane

    // Method to update the position of the shape
    void updatePosition(double elapsedTime, double paneWidth, double paneHeight);

    void initialise(Pane pane);

    Shape returnShape();
}
