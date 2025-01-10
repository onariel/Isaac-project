package isaac.isep.isaacproject;

import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings({"unused", "FieldCanBeLocal", "FieldMayBeFinal"})

public class Task {
    public int id;
    public String name;
    public String description;
    public int priority;
    public Date dueDate;
    public Boolean status;
    public ArrayList<Employee> employees;
    public ArrayList<String> comments;

    //Constructor
    public Task(int id, String name, String description, int priority, Date dueDate, Boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = status;
        this.employees = new ArrayList<>();
        this.comments = new ArrayList<>();
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

    public void getPriority() {
        DataBaseManager.getSpecificAttribute(this, "priority");
    }

    public void getDueDate() {
        DataBaseManager.getSpecificAttribute(this, "dueDate");
    }

    public void getStatus() {
        DataBaseManager.getSpecificAttribute(this, "status");
    }

    public void getEmployees() {
        DataBaseManager.getSpecificAttribute(this, "employees");
    }

    public void getComments() {
        DataBaseManager.getSpecificAttribute(this, "comments");
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

    public void setPriority(int priority) {
        DataBaseManager.modifyObjectAttribute(this, "priority", priority);
    }

    public void setDueDate(Date dueDate) {
        DataBaseManager.modifyObjectAttribute(this, "dueDate", dueDate);
    }

    public void setStatus(Boolean status) {
        DataBaseManager.modifyObjectAttribute(this, "status", status);
    }

    public void setEmployees(ArrayList<Employee> employees) {
        DataBaseManager.modifyObjectAttribute(this, "employees", employees);
    }

    public void setComments(ArrayList<String> comments) {
        DataBaseManager.modifyObjectAttribute(this, "comments", comments);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        DataBaseManager.modifyObjectAttribute(this, "employees", this.employees);
    }

    public void addComment(String comment) {
        this.comments.add(comment);
        DataBaseManager.modifyObjectAttribute(this, "comments", this.comments);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
        DataBaseManager.modifyObjectAttribute(this, "employees", this.employees);
    }

    public void removeComment(String comment) {
        this.comments.remove(comment);
        DataBaseManager.modifyObjectAttribute(this, "comments", this.comments);
    }

    public void remove() {
        DataBaseManager.removeObjectFromJson(this);
    }
}
