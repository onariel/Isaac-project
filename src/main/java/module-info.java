module isaac.isep.isaacproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens isaac.isep.isaacproject to javafx.fxml;
    exports isaac.isep.isaacproject;
    exports isaac.isep.isaacproject.Controllers;
    opens isaac.isep.isaacproject.Controllers to javafx.fxml;
}