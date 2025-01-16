package isaac.isep.isaacproject.Controllers;

import isaac.isep.isaacproject.Backend.Project;
import isaac.isep.isaacproject.Backend.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class CalendarViewController {

    @FXML
    private Label monthYearLabel;

    @FXML
    private GridPane calendarGrid;

    private YearMonth currentYearMonth;

    public void initialize() {
        currentYearMonth = YearMonth.now();
        updateCalendar();
    }

    private void updateCalendar() {
        monthYearLabel.setText(currentYearMonth.getMonth().toString() + " " + currentYearMonth.getYear());

        LocalDate firstOfMonth = currentYearMonth.atDay(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        calendarGrid.getChildren().clear();

        for (int day = 1; day <= currentYearMonth.lengthOfMonth(); day++) {
            Label dayLabel = new Label(String.valueOf(day));
            int column = (dayOfWeek + day - 2) % 7;
            int row = (dayOfWeek + day - 2) / 7;
            calendarGrid.add(dayLabel, column, row);
        }

        List<Project> projects = getProjectsForCurrentMonth();
        for (Project project : projects) {
            addProjectToCalendar(project);
        }
    }

    private List<Project> getProjectsForCurrentMonth() {
        return List.of();
    }

    private void addProjectToCalendar(Project project) {
        LocalDate startDate = project.getStartDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = project.getEndDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (date.getMonth() == currentYearMonth.getMonth() && date.getYear() == currentYearMonth.getYear()) {
                int dayOfMonth = date.getDayOfMonth();
                int dayOfWeek = date.getDayOfWeek().getValue();
                int column = (dayOfWeek - 1) % 7;
                int row = (dayOfMonth + dayOfWeek - 2) / 7;

                Label projectLabel = new Label(project.getName());
                calendarGrid.add(projectLabel, column, row);
            }
        }

        for (Task task : project.getTasks()) {
            addTaskToCalendar(task);
        }
    }

    private void addTaskToCalendar(Task task) {
        LocalDate startDate = task.getProject().getStartDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = task.getDueDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (date.getMonth() == currentYearMonth.getMonth() && date.getYear() == currentYearMonth.getYear()) {
                int dayOfMonth = date.getDayOfMonth();
                int dayOfWeek = date.getDayOfWeek().getValue();
                int column = (dayOfWeek - 1) % 7;
                int row = (dayOfMonth + dayOfWeek - 2) / 7;

                Label taskLabel = new Label(task.getName());
                calendarGrid.add(taskLabel, column, row);
            }
        }
    }
}