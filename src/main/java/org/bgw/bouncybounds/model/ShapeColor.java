package org.bgw.bouncybounds.model;

import javafx.scene.paint.Color;
import java.util.Random;

public enum ShapeColor {
    RED(Color.RED),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    YELLOW(Color.YELLOW),
    ORANGE(Color.ORANGE),
    PURPLE(Color.PURPLE),
    CYAN(Color.CYAN),
    MAGENTA(Color.MAGENTA);

    private final Color color;

    ShapeColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public static Color getRandomColor() {
        Random random = new Random();
        return values()[random.nextInt(values().length)].getColor();
    }
}