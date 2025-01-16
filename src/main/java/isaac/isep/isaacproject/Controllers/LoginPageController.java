package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Apiconector.PostgresqlManager;
import isaac.isep.isaacproject.RunApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {
    @FXML
    private Label ErrorMessage;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    public void OnLogin() {
        if(!email.getText().isEmpty() && !password.getText().isEmpty()) {
            PostgresqlManager postgresqlManager = new PostgresqlManager();
            if (postgresqlManager.Login(email.getText(),password.getText()) != null){
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(RunApplication.class.getResource("Main-Page.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    Scene scene = new Scene(root, 800, 300);
                    stage.setTitle("Main page");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    @FXML
    public void create_an_account() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RunApplication.class.getResource("Account-creation-page.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root, 800, 300);
            stage.setTitle("Account creation page");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}