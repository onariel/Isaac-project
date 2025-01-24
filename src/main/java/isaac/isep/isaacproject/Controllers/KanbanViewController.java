package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Backend.Employee;
import isaac.isep.isaacproject.Backend.Project;
import isaac.isep.isaacproject.Backend.Task;
import isaac.isep.isaacproject.Apiconector.PostgresqlManager;
import isaac.isep.isaacproject.RunApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class KanbanViewController implements Initializable, EmployeeIdAware {

    @FXML
    private Menu projectsMenu;

    @FXML
    private TabPane projectsTabPane;

    private int employeeId;
    PostgresqlManager postgresqlManager = new PostgresqlManager();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization code, if needed, can be placed here
    }

    private void loadProjects(int employeeId) {
        Employee employee = postgresqlManager.getEmployee(employeeId);

        if (employee != null) {
            List<Project> projects = postgresqlManager.getProjects(employeeId);
            for (Project project : projects) {
                // Create Menu Item
                MenuItem menuItem = new MenuItem(project.getName());
                menuItem.setOnAction(e -> addProjectTab(project));
                projectsMenu.getItems().add(menuItem);

                // Add a default tab for each project
                addProjectTab(project);
            }
        } else {
            // Handle case where employee is not found
            System.err.println("Employee not found for ID: " + employeeId);
        }
    }

    private void addProjectTab(Project project) {
        Tab tab = new Tab(project.getName());
        projectsTabPane.getTabs().add(tab);

        HBox kanbanBoard = new HBox(10);
        kanbanBoard.setPadding(new Insets(10));

        // Create columns for each status
        Map<Long, VBox> statusColumns = new HashMap<>();
        Long id = 0L;
        for (String status : Arrays.asList("To Do", "In Progress", "Done")) {
            VBox column = new VBox(10);
            column.getChildren().add(new Label(status));
            statusColumns.put(id, column);
            kanbanBoard.getChildren().add(column);
            id++;
        }
        // Add tasks to the appropriate columns
        if (project.getTasks() != null) {
            for (Task task : project.getTasks()) {
                VBox card = createCard(task);
                long status = task.getStatus();
                if (statusColumns.containsKey(status)) {
                    HBox hBox = new HBox(10);
                    hBox.setPadding(new Insets(10));
                    Button details = new Button("Details");
                    hBox.getChildren().add(details);
                    details.setOnAction(e -> {
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(RunApplication.class.getResource("Task-Details.fxml"));
                            Parent root = fxmlLoader.load();

                            TaskDetailsController controller = fxmlLoader.getController();
                            controller.initialize(task,project, employeeId);
                            Stage stage = new Stage();
                            Scene scene = new Scene(root, 500, 500);
                            stage.setTitle("Task details");
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException a) {
                            throw new RuntimeException(a);
                        }
                    });
                    if(status == -1){
                        Button startTask = new Button("Start Task");
                        startTask.setOnAction(e -> {
                            task.setStatus(0);
                        });
                        statusColumns.get(status).getChildren().addAll(startTask);
                    }
                    if (status == 0) {
                        Button completeTask = new Button("complete Task");
                        completeTask.setOnAction(e -> {
                            task.setStatus(1);
                        });
                        hBox.getChildren().addAll(completeTask);
                    }
                    statusColumns.get(status).getChildren().addAll(card, hBox);
                }
            }
        }
        tab.setContent(kanbanBoard);
    }

    private VBox createCard(Task task) {
        VBox card = new VBox(5);
        card.setStyle("-fx-background-color: lightblue; -fx-border-color: grey; -fx-padding: 10;");

        Label nameLabel = new Label(task.getName());
        Label descLabel = new Label(task.getDescription());

        card.getChildren().addAll(nameLabel, descLabel);
        // Add more details or interactions as needed

        return card;
    }

    @Override
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        loadProjects(employeeId);
    }

    @Override
    public int getEmployeeId() {
        return this.employeeId;
    }
}