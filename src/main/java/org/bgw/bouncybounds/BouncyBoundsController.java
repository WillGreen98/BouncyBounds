package org.bgw.bouncybounds;

import javafx.fxml.FXML;
import org.bgw.bouncybounds.controller.MenuController;
import org.bgw.bouncybounds.controller.ShapesController;

public class BouncyBoundsController {
    @FXML
    private ShapesController shapesController;

    @FXML
    private MenuController menuController;

    public void initialize() {
        System.out.println("MainController initialized");
    }

    // Methods to interact with nested controllers
    public ShapesController getShapesController() {
        return shapesController;
    }

    public MenuController getMenuController() {
        return menuController;
    }
}