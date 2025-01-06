module isaac.isep.isaacproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens isaac.isep.isaacproject to javafx.fxml;
    exports isaac.isep.isaacproject;
}