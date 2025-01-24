package isaac.isep.isaacproject.Backend;

import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings({"unused", "FieldCanBeLocal", "FieldMayBeFinal"})

public class Task {
    public long id;
    public String name;
    public String description;
    public int priority;
    public Date dueDate;
    public long status;
    public Employee employee;
    public ArrayList<String> comments;
    public Project project;
    public float budget;

    //Constructor
    public Task(String name, String description, int priority, Date dueDate, Project project, float budget, Employee employee) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = 0;
        this.employee = employee;
        this.comments = new ArrayList<>();
        this.project = project;
        this.budget = budget;
        this.project.addTask(this);
    }

    public Task(){}

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", comments=" + comments +
                ", budget=" + budget +
                ", employee=" + employee.getName() +
                '}';
    }


    //Getters and Setters


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public long getStatus() {
        return status;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public Project getProject() {
        return project;
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

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }


    public void removeComment(String comment) {
        this.comments.remove(comment);
    }
}
