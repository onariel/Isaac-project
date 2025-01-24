package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Apiconector.PostgresqlManager;
import isaac.isep.isaacproject.Backend.Project;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AddEmployeeToProjectController implements EmployeeIdAware {


    @FXML
    private ComboBox<String> projects;

    private int employeeId;

    @FXML
    private TextField employeeEmail;

    private List<Project> projectList;

    @FXML
    private Label errorLabel;

    @FXML
    public void addEmployeeToProject() {
        if (employeeEmail.getText().isEmpty() || projects.getValue().isEmpty()) {
            errorLabel.setText("Please fill all the fields");
        }else{
            PostgresqlManager postgresqlManager = new PostgresqlManager();
            if(postgresqlManager.getEmployeeByEmail(employeeEmail.getText())==null){
                errorLabel.setText("Email does not exist");
            }else{
                boolean condition = true;
                long projectId = projectList.get(Integer.valueOf((projects.getValue().split(" ")[0]))).getId();
                List<Project> employeeProjects = postgresqlManager.getProjects(postgresqlManager.getEmployeeByEmail(employeeEmail.getText()).getId());
                for(Project project : employeeProjects){
                    if(projectId == project.getId()){
                        condition = false;
                    }
                }
                if(condition) {
                    postgresqlManager.addEmployeeToProject(projectId, employeeEmail.getText());
                    Stage stage = (Stage) projects.getScene().getWindow();
                    stage.close();
                }else {
                    errorLabel.setText("This employee is already in this project");
                }
            }
        }
    }

    @FXML
    public void calcel(){
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        stage.close();
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
                id++;
            }
        }
        if(projectList.isEmpty()) {
            errorLabel.setText("You only can add people to project that you managed, please create a project first");
        }
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }
}
