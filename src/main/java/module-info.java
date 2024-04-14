module org.bgw.bouncybounds {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.bgw.bouncybounds to javafx.fxml;
    exports org.bgw.bouncybounds;


    opens org.bgw.bouncybounds.controller to javafx.fxml;
    exports org.bgw.bouncybounds.controller;
}