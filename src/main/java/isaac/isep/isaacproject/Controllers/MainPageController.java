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


    private int employeeId;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @FXML
    private void goToProjectCreation() {
        loadPage("Project-creation-page.fxml", employeeId);
    }

    @FXML
    private void goToTaskCreation() {
        loadPage("Task-Creation.fxml", employeeId);
    }

    @FXML
    private void goToTaskManagement() {
        loadPage("Task-Management.fxml", employeeId);
    }

    @FXML
    private void goToEmployeeManagement() {
        loadPage("Employee-Management.fxml", employeeId);
    }

    @FXML
    private void goToProjectManagement() {
        loadPage("Project-Management.fxml", employeeId);
    }

    @FXML
    private void goToKanbanView() {
        loadPage("Kanban-view.fxml", employeeId);
    }

    @FXML
    private void goToCalendarView() {
        loadPage("Calendar-View.fxml", employeeId);
    }

    @FXML
    private void goToGenerationReport() {
        loadPage("ReportGeneration.fxml", employeeId);
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