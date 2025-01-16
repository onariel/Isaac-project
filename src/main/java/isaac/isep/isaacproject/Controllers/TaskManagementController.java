package isaac.isep.isaacproject.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TaskManagementController {

    @FXML
    private Label currentTaskNameLabel;
    @FXML
    private TextField taskNameField;

    @FXML
    private Label currentDescriptionLabel;
    @FXML
    private TextArea descriptionField;

    @FXML
    private Label currentPriorityLabel;
    @FXML
    private TextField priorityField;

    @FXML
    private Label currentDueDateLabel;
    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private Label currentStatusLabel;
    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private Label currentEmployeesLabel;
    @FXML
    private VBox employeesVBox;

    @FXML
    private Label currentCommentsLabel;
    @FXML
    private TextArea commentsField;

    @FXML
    private Label currentProjectLabel;
    @FXML
    private TextField projectField;

    @FXML
    private Label currentBudgetLabel;
    @FXML
    private TextField budgetField;

    @FXML
    private void saveTaskDetails() {
        String newTaskName = taskNameField.getText();
        String newDescription = descriptionField.getText();
        String newPriority = priorityField.getText();
        String newDueDate = dueDatePicker.getValue().toString();
        String newStatus = statusComboBox.getValue();
        String newProject = projectField.getText();
        String newBudget = budgetField.getText();
        String newComments = commentsField.getText();

        currentTaskNameLabel.setText(newTaskName);
        currentDescriptionLabel.setText(newDescription);
        currentPriorityLabel.setText(newPriority);
        currentDueDateLabel.setText(newDueDate);
        currentStatusLabel.setText(newStatus);
        currentProjectLabel.setText(newProject);
        currentBudgetLabel.setText(newBudget);
        currentCommentsLabel.setText(newComments);
    }
}