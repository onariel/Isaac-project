package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Apiconector.PostgresqlManager;
import isaac.isep.isaacproject.Backend.Project;
import isaac.isep.isaacproject.Report;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReportGenerationController implements EmployeeIdAware {

    @FXML
    private ComboBox<Project> projectComboBox;

    private Report reportGenerator = new Report();
    private String filePath = "report.pdf";
    private int employeeId = -1;

    @FXML
    public void initialize() {
        if (employeeId != -1) {
            List<Project> projects = loadProjects(employeeId);
            projectComboBox.getItems().addAll(projects);
        }
        else {
            employeeId = getEmployeeId();
            List<Project> projects = loadProjects(employeeId);
            projectComboBox.getItems().addAll(projects);
        }
    }

    @FXML
    private void generateReport() {
        Project selectedProject = projectComboBox.getSelectionModel().getSelectedItem();
        if (selectedProject != null) {
            String reportContent = reportGenerator.generateProjectProgressReport(selectedProject);
            reportGenerator.exportReportToPDF(reportContent, filePath);
        }
    }

    @FXML
    private void visualizePDF() {
        File file = new File(filePath);
        if (file.exists()) {
            try {
                Desktop.getDesktop().browse(file.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Project> loadProjects(int employeeId) {
        PostgresqlManager postgresqlManager = new PostgresqlManager();
        return postgresqlManager.getProjects(employeeId);
    }

    @Override
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        if (projectComboBox != null) {
            List<Project> projects = loadProjects(employeeId);
            projectComboBox.getItems().addAll(projects);
        }
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }
}