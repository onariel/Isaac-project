package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Backend.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountCreationPageController {


    @FXML
    private TextField Id;

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

    @FXML
    public void createAccount() {
        if(Id.getText().isEmpty() || Name.getText().isEmpty() || email.getText().isEmpty() || Password.getText().isEmpty() || ConfirmPassword.getText().isEmpty()) {
            errorMessage.setText("Please fill all the fields");
        }else {
            if (Password.getText().equals(ConfirmPassword.getText())) {
                Employee account = new Employee(Name.getText(), email.getText(), Role.getText(), Password.getText());
                Stage stage = (Stage) Id.getScene().getWindow();
                stage.close();
            }else{
                errorMessage.setText("Passwords do not match");
            }
        }
    }

    @FXML
    public void clear(){
        Id.clear();
        Name.clear();
        email.clear();
        Password.clear();
        ConfirmPassword.clear();
        Role.clear();
    }

}
