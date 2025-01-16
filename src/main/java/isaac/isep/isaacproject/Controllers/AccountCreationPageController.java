package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Apiconector.PostgresqlManager;
import isaac.isep.isaacproject.Backend.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountCreationPageController {

    @FXML
    private TextField Name;

    @FXML
    private TextField email;

    @FXML
    private TextField Password;

    @FXML
    private TextField ConfirmPassword;

    @FXML
    private TextField Role;

    @FXML
    private Label errorMessage;

    public static PostgresqlManager postgresqlManager;

    @FXML
    public void createAccount() {
        PostgresqlManager postgresqlManager = new PostgresqlManager();
        if(Name.getText().isEmpty() || email.getText().isEmpty() || Password.getText().isEmpty() || ConfirmPassword.getText().isEmpty()) {
            errorMessage.setText("Please fill all the fields");
            }else{
            if (postgresqlManager.getEmployeeByEmail(email.getText()) != null) {
                errorMessage.setText("This email already exists");
            } else {
                if (Password.getText().equals(ConfirmPassword.getText())) {
                    postgresqlManager.createEmployee(Name.getText(), email.getText(), Role.getText(), Password.getText());
                    Stage stage = (Stage) Name.getScene().getWindow();
                    stage.close();
                } else {
                    errorMessage.setText("Passwords do not match");
                }
            }
        }
    }

    @FXML
    public void clear(){
        Name.clear();
        email.clear();
        Password.clear();
        ConfirmPassword.clear();
        Role.clear();
        errorMessage.setText("");
    }

}
