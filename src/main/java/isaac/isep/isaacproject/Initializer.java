package isaac.isep.isaacproject;

import isaac.isep.isaacproject.Backend.Employee;
import isaac.isep.isaacproject.Backend.Project;
import isaac.isep.isaacproject.Backend.Task;

import java.util.Date;

@SuppressWarnings({"unused", "FieldCanBeLocal", "FieldMayBeFinal"})

public class Initializer {
    public static void main(String[] args) {
        DataBaseManager.clearDatabase();

        // Create employees
        Employee employee0 = new Employee( "Employee0", "employee0@isaac.isep", "Role1", "password");
        Employee employee1 = new Employee( "Employee1", "employee1@isaac.isep", "Role1", "password");
        Employee employee2 = new Employee( "Employee2", "employee2@isaac.isep", "Role1", "password");
        Employee employee3 = new Employee( "Employee3", "employee3@isaac.isep", "Role1", "password");
        Employee employee4 = new Employee( "Employee4", "employee4@isaac.isep", "Role3", "password");
        Employee employee5 = new Employee( "Employee5", "employee5@isaac.isep", "Role1", "password");
        Employee employee6 = new Employee( "Employee6", "employee6@isaac.isep", "Role2", "password");
        Employee employee7 = new Employee( "Employee7", "employee7@isaac.isep", "Role2", "password");
        Employee employee8 = new Employee( "Employee8", "employee8@isaac.isep", "Role2", "password");

        Date currentDate = new Date();

        // Create projects
        Date dueDate0 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 7);
        Project project0 = new Project(0, "Project0", "Description0", currentDate, dueDate0, false, employee0, 40000);

        Date dueDate1 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 13);
        Project project1 = new Project(1, "Project1", "Description1", currentDate, dueDate1, false, employee1, 51631);

        Date dueDate2 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 21);
        Project project2 = new Project(2, "Project2", "Description2", currentDate, dueDate2, false, employee2, 5632133);

        // Create tasks
        Date dueDate00 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 2);
        Task task0 = new Task(0, "Task0", "Description0", 0, (dueDate00), false, project0, 5121);

        Date dueDate01 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 3);
        Task task1 = new Task(1, "Task1", "Description1", 1, (dueDate01), false, project0, 512);

        Date dueDate02 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 5);
        Task task2 = new Task(2, "Task2", "Description2", 2, (dueDate02), false, project1, 12112);

        Date dueDate11 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 2);
        Task task11 = new Task(11, "Task11", "Description11", 0, (dueDate11), false, project1, 5812);

        Date dueDate12 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 7);
        Task task12 = new Task(12, "Task12", "Description12", 1, (dueDate12), false, project1, 128632);

        Date dueDate21 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 8);
        Task task21 = new Task(21, "Task21", "Description21", 0, (dueDate21), false, project2, 1812);

        Date dueDate22 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 13);
        Task task22 = new Task(22, "Task22", "Description22", 1, (dueDate22), false, project2, 4521);

        Date dueDate23 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 16);
        Task task23 = new Task(23, "Task23", "Description23", 2, (dueDate23), false, project2, 9821);

        Date dueDate24 = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 21);
        Task task24 = new Task(24, "Task24", "Description24", 3, (dueDate24), false, project2, 3875);

        // Generate report
        Report report = new Report();
        report.generateBudgetReport(project0);
        report.exportReportToPDF(report.generateProjectProgressReport(project0), "src/main/resources/test.pdf");
    }
}