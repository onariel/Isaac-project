package isaac.isep.isaacproject;

import java.util.ArrayList;
import java.util.Date;

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
    }
}
