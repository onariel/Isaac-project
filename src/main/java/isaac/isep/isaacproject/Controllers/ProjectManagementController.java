package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Backend.Project;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class ProjectManagementController implements Initializable {

    @FXML
    private TextField projectNameField;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TextArea descriptionField;

    @FXML
    private Label currentProjectNameLabel;

    @FXML
    private Label currentStartDateLabel;

    @FXML
    private Label currentEndDateLabel;

    @FXML
    private Label currentDescriptionLabel;

    private Project project;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (project != null) {
            currentProjectNameLabel.setText(project.getName());
            currentStartDateLabel.setText(project.getStartDate().toString());
            currentEndDateLabel.setText(project.getEndDate().toString());
            currentDescriptionLabel.setText(project.getDescription());
        }
    }

    public void setProject(Project project) {
        this.project = project;
        if (currentProjectNameLabel != null) {
            currentProjectNameLabel.setText(project.getName());
            currentStartDateLabel.setText(project.getStartDate().toString());
            currentEndDateLabel.setText(project.getEndDate().toString());
            currentDescriptionLabel.setText(project.getDescription());
        }
    }

    @FXML
    private void saveProjectDetails() {
        project.setName(projectNameField.getText());
        project.setStartDate(convertToDate(startDatePicker.getValue()));
        project.setEndDate(convertToDate(endDatePicker.getValue()));
        project.setDescription(descriptionField.getText());

        System.out.println("Project details saved: " + project);
    }

    private Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}