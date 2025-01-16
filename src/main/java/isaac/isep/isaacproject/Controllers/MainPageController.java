package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Backend.Employee;
import isaac.isep.isaacproject.Backend.Project;
import isaac.isep.isaacproject.RunApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {

    private Employee employee;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button create_a_project;

    @FXML
    private VBox vBox;

    private void initialize(Employee employee) {
        this.employee = employee;
        for (Project project : employee.getProjects()) {
            HBox hBox = new HBox();
            vBox.getChildren().add(hBox);
            TextField name = new TextField(project.getName());
            TextField start_date = new TextField(project.getStartDate().toString());
            TextField end_date = new TextField(project.getEndDate().toString());
            name.setEditable(false);
            start_date.setEditable(false);
            end_date.setEditable(false);
            Button open = new Button("Open");
            open.setOnAction(e -> {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(RunApplication.class.getResource("Kanban-view.fxml"));
                    Parent root = null;
                    root = fxmlLoader.load();
                    KanbanViewController controller =  fxmlLoader.getController();
                    controller.initialize(project);
                    Stage stage = new Stage();
                    Scene scene = new Scene(root, 600, 400);
                    stage.setTitle("Your mails");
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }
}
