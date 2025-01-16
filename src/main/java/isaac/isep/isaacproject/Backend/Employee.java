package isaac.isep.isaacproject.Backend;

import java.util.ArrayList;

@SuppressWarnings({"unused", "FieldCanBeLocal", "FieldMayBeFinal"})


public class Employee {
    public int id;
    public String name;
    public String email;
    public String role;
    public String password;
    public ArrayList<Project> projects;

    //Constructor
    public Employee(String name, String email, String role, String password) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
        this.projects = new ArrayList<>();
    }

    public Employee(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.projects = new ArrayList<>();
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
