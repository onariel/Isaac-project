package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Backend.Employee;
import isaac.isep.isaacproject.Backend.Project;
import isaac.isep.isaacproject.Backend.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class TaskCreationController implements Initializable {

    @FXML
    private TextField taskNameField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField priorityField;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private VBox employeesVBox;

    @FXML
    private TextArea commentsField;

    @FXML
    private TextField projectField;

    @FXML
    private TextField budgetField;

    private ArrayList<Employee> employees;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        statusComboBox.getItems().addAll("Not Started", "In Progress", "Completed");
        employees = getAllEmployees();
        populateEmployeeCheckboxes();
    }

    private void populateEmployeeCheckboxes() {
        for (Employee employee : employees) {
            CheckBox checkBox = new CheckBox(employee.getName());
            checkBox.setUserData(employee);
            employeesVBox.getChildren().add(checkBox);
        }
    }

    @FXML
    private void createTask() {
        String name = taskNameField.getText();
        String description = descriptionField.getText();
        int priority = Integer.parseInt(priorityField.getText());
        Date dueDate = convertToDate(dueDatePicker.getValue());
        ArrayList<Employee> selectedEmployees = getSelectedEmployees();
        ArrayList<String> comments = parseComments(commentsField.getText());
        Project project = getProjectByName(projectField.getText());
        float budget = Float.parseFloat(budgetField.getText());

        Task task = new Task(name, description, priority, dueDate, project, budget);
        task.setEmployees(selectedEmployees);
        task.setComments(comments);

        System.out.println("Task created: " + task);
    }

    private ArrayList<Employee> getSelectedEmployees() {
        ArrayList<Employee> selectedEmployees = new ArrayList<>();
        for (javafx.scene.Node node : employeesVBox.getChildren()) {
            CheckBox checkBox = (CheckBox) node;
            if (checkBox.isSelected()) {
                selectedEmployees.add((Employee) checkBox.getUserData());
            }
        }
        return selectedEmployees;
    }

    private Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private ArrayList<String> parseComments(String commentsText) {
        // Implement logic to parse comments from the text
        return new ArrayList<>();
    }

    private Project getProjectByName(String projectName) {
        // Implement logic to get the project by name
        return new Project();
    }

    private ArrayList<Employee> getAllEmployees() {
        // Implement logic to get all employees
        return new ArrayList<>();
    }
}