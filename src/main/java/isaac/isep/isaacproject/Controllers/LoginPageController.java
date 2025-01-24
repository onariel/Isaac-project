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
        if (!email.getText().isEmpty() && !password.getText().isEmpty()) {
            PostgresqlManager postgresqlManager = new PostgresqlManager();
            if (postgresqlManager.Login(email.getText(), password.getText()) != null) {
                Integer employeeId = Math.toIntExact(postgresqlManager.Login(email.getText(), password.getText()));
                System.out.println(employeeId);
                if (employeeId != null) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(RunApplication.class.getResource("Main-Page.fxml"));
                        Parent root = fxmlLoader.load();

                        // Get the controller of the main page
                        MainPageController mainPageController = fxmlLoader.getController();
                        // Set the employee ID
                        mainPageController.setEmployeeId(employeeId);

                        Stage stage = new Stage();
                        Scene scene = new Scene(root, 500, 400);
                        stage.setTitle("Main page");
                        stage.setScene(scene);
                        stage.show();
                        Stage stage1 = (Stage) email.getScene().getWindow();
                        stage1.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    ErrorMessage.setText("Invalid login credentials");
                }
            } else {
                ErrorMessage.setText("Please enter email and password");
            }
        }else{
            ErrorMessage.setText("The email or password are wrong");
        }
    }

    @FXML
    public void create_an_account() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RunApplication.class.getResource("Account-creation-page.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root, 800, 500);
            stage.setTitle("Account creation page");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}