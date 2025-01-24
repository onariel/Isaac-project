package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Apiconector.PostgresqlManager;
import isaac.isep.isaacproject.Backend.Project;
import isaac.isep.isaacproject.Backend.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.time.ZoneId;
import java.util.Date;

public class TaskDetailsController {

    @FXML
    private HBox Namehbox;

    @FXML
    private HBox Descriptionhbox;

    @FXML
    private HBox priorityhbox;

    @FXML
    private HBox datehbox;

    @FXML
    private HBox employeehbox;

    @FXML
    private HBox projecthbox;

    @FXML
    private HBox budjethbox;

    @FXML
    private Label errormessage;

    public void initialize(Task task, Project project, long employeeId) {
        PostgresqlManager postgresqlManager = new PostgresqlManager();
        if(project.getProjectManager().getId() == employeeId) {
            TextField name = new TextField(task.getName());
            Button saveName = new Button("Save");
            saveName.setOnAction(event -> {
               postgresqlManager.setTaskName(task.getId(), name.getText());
               errormessage.setText("Name as been changed");
            });
            Namehbox.getChildren().addAll(name, saveName);


            TextArea description = new TextArea(task.getDescription());
            description.setPrefWidth(400);
            Button savedescription = new Button("Save");
            savedescription.setOnAction(event -> {
                postgresqlManager.setTaskDescription(task.getId(), description.getText());
                errormessage.setText("Description as been changed");
            });
            Descriptionhbox.getChildren().addAll(description, savedescription);


            TextField priority = new TextField("" + task.getPriority());
            Button savepriority = new Button("Save");
            savepriority.setOnAction(event -> {
                postgresqlManager.setTaskPriority(task.getId(), Integer.valueOf(priority.getText()));
                errormessage.setText("employee as been changed");
            });
            priorityhbox.getChildren().addAll(priority, savepriority);


            DatePicker datePicker = new DatePicker(task.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            Button saveDate = new Button("Save");
            saveDate.setOnAction(event -> {
                postgresqlManager.setTaskDueDate(task.getId(), Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                errormessage.setText("due date as been changed");
            });
            datehbox.getChildren().addAll(datePicker, saveDate);

            Label employee = new Label(task.getEmployee().getEmail());
            employeehbox.getChildren().addAll(employee);

            Label projectname = new Label(project.getName());
            projecthbox.getChildren().addAll(projectname);

            TextField budget = new TextField("" + task.getBudget());
            Button savebudget = new Button("Save");
            savebudget.setOnAction(event -> {
                postgresqlManager.setTaskBudget(task.getId(), Float.valueOf(budget.getText()));
                errormessage.setText("budget as been changed");
            });
            budjethbox.getChildren().addAll(budget, savebudget);
        }
    }
}
