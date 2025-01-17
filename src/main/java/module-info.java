module isaac.isep.isaacproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires layout;
    requires kernel;
    requires spring.web;
    requires java.desktop;
    requires spring.core;


    opens isaac.isep.isaacproject to javafx.fxml;
    exports isaac.isep.isaacproject;
    exports isaac.isep.isaacproject.Controllers;
    opens isaac.isep.isaacproject.Controllers to javafx.fxml;
    exports isaac.isep.isaacproject.Backend;
    opens isaac.isep.isaacproject.Backend to javafx.fxml;
    exports isaac.isep.isaacproject.Apiconector;
    opens isaac.isep.isaacproject.Apiconector to javafx.fxml;
}