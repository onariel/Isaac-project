package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.RunApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

@SuppressWarnings({"unused", "FieldCanBeLocal", "FieldMayBeFinal"})

public class MainPageController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button create_a_project;

    @FXML
    private VBox vBox;

    @FXML
    private Label employeeIdLabel;

    private int employeeId;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        // Update the label or perform other actions with the employee ID
        employeeIdLabel.setText("Employee ID: " + employeeId);
    }

    @FXML
    private void goToProjectCreation() {
        loadPage("ProjectCreation.fxml");
    }

    @FXML
    private void goToTaskCreation() {
        loadPage("TaskCreation.fxml");
    }

    @FXML
    private void goToTaskManagement() {
        loadPage("TaskManagement.fxml");
    }

    @FXML
    private void goToEmployeeManagement() {
        loadPage("EmployeeManagement.fxml");
    }

    @FXML
    private void goToProjectManagement() {
        loadPage("ProjectManagement.fxml");
    }

    @FXML
    private void goToKanbanView() {
        loadPage("KanbanView.fxml");
    }

    @FXML
    private void goToCalendarView() {
        loadPage("CalendarView.fxml");
    }

    @FXML
    private void goToGenerationReport() {
        loadPage("GenerationReport.fxml");
    }

    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RunApplication.class.getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setEmployeeId(Integer employeeId) {
    }
}