package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Apiconector.PostgresqlManager;
import isaac.isep.isaacproject.Backend.Employee;
import isaac.isep.isaacproject.Backend.Project;
import isaac.isep.isaacproject.Backend.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class TaskCreationController implements EmployeeIdAware {

    @FXML
    private TextField taskNameField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField priorityField;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private TextField budgetField;

    @FXML
    private TextField employeeEmail;

    private int employeeId;

    @FXML
    private ComboBox<String> projects;

    @FXML
    private Label errorLabel;

    private List<Project> projectList;

    @FXML
    private void createTask() {
        if (projectList.isEmpty()) {
            errorLabel.setText("you dont have any projects where you are the project manager, only the project manager can add task");
        }else {
            if (taskNameField.getText().isEmpty() || descriptionField.getText().isEmpty() || priorityField.getText().isEmpty() || employeeEmail.getText().isEmpty() || projects.getValue().isEmpty() || budgetField.getText().isEmpty()) {
                errorLabel.setText("please fill all the fields");
            }else{
                PostgresqlManager postgresqlManager = new PostgresqlManager();
                if (postgresqlManager.getEmployeeByEmail(employeeEmail.getText()) == null) {
                    errorLabel.setText("Employee not found, please select a correct email");
                } else {
                    String name = taskNameField.getText();
                    String description = descriptionField.getText();
                    int priority = Integer.parseInt(priorityField.getText());
                    Date dueDate = convertToDate(dueDatePicker.getValue());
                    Employee selectedEmployee = postgresqlManager.getEmployeeByEmail(employeeEmail.getText());
                    float budget = Float.parseFloat(budgetField.getText());
                    Project project = this.projectList.get(Integer.valueOf(projects.getValue().split(" ")[0]));
                    postgresqlManager.createTask(name,description,priority,dueDate,project,budget);
                    Stage stage = (Stage) errorLabel.getScene().getWindow();
                    stage.close();
                }
            }
        }
    }

    private Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public void setEmployeeId(int employeeId) {
        PostgresqlManager postgresqlManager = new PostgresqlManager();
        this.employeeId = employeeId;
        List<Project> managedProjects = new ArrayList<>();
        List<Project> project = postgresqlManager.getProjects(employeeId);
        for(int i = 0; i < project.size(); i++) {
            if(project.get(i).getProjectManager().getId() == employeeId) {
                managedProjects.add(project.get(i));
            }
        }
        this.projectList = managedProjects;
        int id = 0;
        if (!projectList.isEmpty()) {
            for (Project p : projectList) {
                projects.getItems().addAll(id + " " + p.getName());
            }
            id++;
        }
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }
}