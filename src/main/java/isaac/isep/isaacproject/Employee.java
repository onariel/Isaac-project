package isaac.isep.isaacproject;

import java.util.ArrayList;

public class Employee {

    private final int id;
    private String name;
    private String email;
    private String role;
    private ArrayList<Project> projects;
    private String password;

    public Employee(int id, String name, String email, String role, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
        this.projects = new ArrayList<>();
    }
}
