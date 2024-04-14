package org.bgw.bouncybounds;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BouncyBoundsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BouncyBoundsApplication.class.getResource("view/bouncybounds.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setMinWidth(580);

        BouncyBoundsController controller = fxmlLoader.getController();

        stage.setScene(scene);
        stage.setTitle("Bouncing Circle App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}