package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Apiconector.PostgresqlManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ProjectCreationPageController implements EmployeeIdAware {

    @FXML
    private TextField projectName;

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;

    @FXML
    private TextArea projectDescription;

    @FXML
    private TextField Budget;

    private int employeeId;

    @FXML
    private Label errorLabel;

    @FXML
    public void createProject() {
        if(projectDescription.getText() != null && !projectDescription.getText().isEmpty() && startDate.getValue() != null && endDate.getValue() != null && Budget.getText() != null && !Budget.getText().isEmpty()) {
            PostgresqlManager postgresqlManager = new PostgresqlManager();
            ZoneId defaultZoneId = ZoneId.systemDefault();
            postgresqlManager.createProject(projectName.getText(), projectDescription.getText(), Date.from(startDate.getValue().atStartOfDay(defaultZoneId).toInstant()), Date.from(endDate.getValue().atStartOfDay(defaultZoneId).toInstant()), false, postgresqlManager.getEmployee(employeeId), Float.valueOf(Budget.getText()));
        }else{
            errorLabel.setText("Please fill all the fields");
        }
    }

    @FXML
    public void cancelProject() {
        Stage stage = (Stage) Budget.getScene().getWindow();
        stage.close();
    }

    @Override
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }
}
