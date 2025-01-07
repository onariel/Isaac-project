package isaac.isep.isaacproject;

import java.util.ArrayList;
import java.util.Date;

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
    }
}
