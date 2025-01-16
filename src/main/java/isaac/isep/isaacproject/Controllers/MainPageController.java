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
        employeeIdLabel.setText("Employee ID: " + employeeId);
    }

    @FXML
    private void goToProjectCreation() {
        loadPage("ProjectCreation.fxml", employeeId);
    }

    @FXML
    private void goToTaskCreation() {
        loadPage("TaskCreation.fxml", employeeId);
    }

    @FXML
    private void goToTaskManagement() {
        loadPage("TaskManagement.fxml", employeeId);
    }

    @FXML
    private void goToEmployeeManagement() {
        loadPage("EmployeeManagement.fxml", employeeId);
    }

    @FXML
    private void goToProjectManagement() {
        loadPage("ProjectManagement.fxml", employeeId);
    }

    @FXML
    private void goToKanbanView() {
        loadPage("KanbanView.fxml", employeeId);
    }

    @FXML
    private void goToCalendarView() {
        loadPage("CalendarView.fxml", employeeId);
    }

    @FXML
    private void goToGenerationReport() {
        loadPage("GenerationReport.fxml", employeeId);
    }

    private void loadPage(String fxmlFile, int employeeId) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RunApplication.class.getResource(fxmlFile));
            Parent root = fxmlLoader.load();

            Object controller = fxmlLoader.getController();
            if (controller instanceof EmployeeIdAware) {
                ((EmployeeIdAware) controller).setEmployeeId(employeeId);
            }

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}