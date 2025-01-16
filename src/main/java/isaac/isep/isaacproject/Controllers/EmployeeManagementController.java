package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Backend.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeManagementController implements Initializable {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    private Employee employee;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (employee != null) {
            nameField.setText(employee.getName());
            emailField.setText(employee.getEmail());
            passwordField.setText(employee.getPassword());
        }
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @FXML
    private void saveEmployeeDetails() {
        employee.setName(nameField.getText());
        employee.setEmail(emailField.getText());
        employee.setPassword(passwordField.getText());

        System.out.println("Employee details saved: " + employee);
    }
}