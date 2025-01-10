package isaac.isep.isaacproject;

import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings({"unused", "FieldCanBeLocal", "FieldMayBeFinal"})

public class Project {
    public int id;
    public String name;
    public String description;
    public Date startDate;
    public Date endDate;
    public Boolean status;
    public ArrayList<Employee> employees;
    public ArrayList<Task> tasks;

    //Constructor
    public Project(int id, String name, String description, Date startDate, Date endDate, Boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.employees = new ArrayList<>();
        this.tasks = new ArrayList<>();
        DataBaseManager.writeObjectToJson(this);
    }

    //Getters and Setters
    public void getId() {
        DataBaseManager.getSpecificAttribute(this, "id");
    }

    public void getName() {
        DataBaseManager.getSpecificAttribute(this, "name");
    }

    public void getDescription() {
        DataBaseManager.getSpecificAttribute(this, "description");
    }

    public void getStartDate() {
        DataBaseManager.getSpecificAttribute(this, "startDate");
    }

    public void getEndDate() {
        DataBaseManager.getSpecificAttribute(this, "endDate");
    }

    public void getStatus() {
        DataBaseManager.getSpecificAttribute(this, "status");
    }

    public void getEmployees() {
        DataBaseManager.getSpecificAttribute(this, "employees");
    }

    public void getTasks() {
        DataBaseManager.getSpecificAttribute(this, "tasks");
    }

    public void getAll() {
        DataBaseManager.getAllAttributes(this);
    }

    public void setId(int id) {
        DataBaseManager.modifyObjectAttribute(this, "id", id);
    }

    public void setName(String name) {
        DataBaseManager.modifyObjectAttribute(this, "name", name);
    }

    public void setDescription(String description) {
        DataBaseManager.modifyObjectAttribute(this, "description", description);
    }

    public void setStartDate(Date startDate) {
        DataBaseManager.modifyObjectAttribute(this, "startDate", startDate);
    }

    public void setEndDate(Date endDate) {
        DataBaseManager.modifyObjectAttribute(this, "endDate", endDate);
    }

    public void setStatus(Boolean status) {
        DataBaseManager.modifyObjectAttribute(this, "status", status);
    }

    public void setEmployees(ArrayList<Employee> employees) {
        DataBaseManager.modifyObjectAttribute(this, "employees", employees);
    }

    public void setTasks(ArrayList<Task> tasks) {
        DataBaseManager.modifyObjectAttribute(this, "tasks", tasks);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        DataBaseManager.modifyObjectAttribute(this, "employees", this.employees);
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        DataBaseManager.modifyObjectAttribute(this, "tasks", this.tasks);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
        DataBaseManager.modifyObjectAttribute(this, "employees", this.employees);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
        DataBaseManager.modifyObjectAttribute(this, "tasks", this.tasks);
    }

    public void deleteProject() {
        DataBaseManager.removeObjectFromJson(this);
    }
}
