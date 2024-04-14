package org.bgw.bouncybounds.model;

public interface Collidable {
    void handleCollisionSameShape(Shape otherShape);
    void handleCollisionDifferentShape(Shape otherShape);
    void handleCollisionBorder(double paneWidth, double paneHeight);
}
