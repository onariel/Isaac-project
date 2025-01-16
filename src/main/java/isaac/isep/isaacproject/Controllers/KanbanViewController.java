package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Apiconector.PostgresqlManager;
import isaac.isep.isaacproject.Backend.Project;
import isaac.isep.isaacproject.Backend.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.List;

public class KanbanViewController implements EmployeeIdAware {

    @FXML
    private VBox toDoVBox;

    @FXML
    private VBox inProgressVBox;

    @FXML
    private VBox finishedVBox;

    private int employeeId;

    @Override
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        loadProjectsAndTasks();
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    private void loadProjectsAndTasks() {
        PostgresqlManager postgresqlManager = new PostgresqlManager();
        List<Project> projects = postgresqlManager.getProjects(employeeId);

        for (Project project : projects) {
            List<Task> tasks = project.getTasks();
            boolean hasInProgress = tasks.stream().anyMatch(task -> task.getStatus() == 0);
            boolean allNotStarted = tasks.stream().allMatch(task -> task.getStatus() == -1);

            ListView<Task> taskListView = new ListView<>();
            taskListView.getItems().addAll(tasks);

            if (project.getStatus()) {
                finishedVBox.getChildren().add(taskListView);
            } else if (hasInProgress) {
                inProgressVBox.getChildren().add(taskListView);
            } else if (allNotStarted) {
                toDoVBox.getChildren().add(taskListView);
            }
        }
    }
}