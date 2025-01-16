package isaac.isep.isaacproject.Backend;

import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings({"unused", "FieldCanBeLocal", "FieldMayBeFinal"})

public class Project {
    public long id;
    public String name;
    public String description;
    public Date startDate;
    public Date endDate;
    public Boolean status;
    public ArrayList<Employee> employees;
    public ArrayList<Task> tasks;
    public Employee projectManager;
    public float budget;

    //Constructor
    public Project(String name, String description, Date startDate, Date endDate, Boolean status, Employee projectManager, float budget) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.employees = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.projectManager = projectManager;
        this.employees.add(projectManager);
        this.budget = budget;
    }

    public Project() {}

    //Getters and Setters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Employee getProjectManager() {
        return projectManager;
    }

    public float getBudget() {
        return budget;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", employees=" + employees +
                ", tasks=" + tasks +
                ", projectManager=" + projectManager +
                ", budget=" + budget +
                '}';
    }
}