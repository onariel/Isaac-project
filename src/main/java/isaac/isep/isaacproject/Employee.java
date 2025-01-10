package isaac.isep.isaacproject;

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
    public Employee(int id, String name, String email, String role, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
        this.projects = new ArrayList<>();
        DataBaseManager.writeObjectToJson(this);
    }

    //Getters and Setters
    public void getId() {
        DataBaseManager.getSpecificAttribute(this, "id");
    }

    public void getName() {
        DataBaseManager.getSpecificAttribute(this, "name");
    }

    public void getEmail() {
        DataBaseManager.getSpecificAttribute(this, "email");
    }

    public void getRole() {
        DataBaseManager.getSpecificAttribute(this, "role");
    }

    public void getProjects() {
        DataBaseManager.getSpecificAttribute(this, "projects");
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

    public void setEmail(String email) {
        DataBaseManager.modifyObjectAttribute(this, "email", email);
    }

    public void setRole(String role) {
        DataBaseManager.modifyObjectAttribute(this, "role", role);
    }

    public void setProjects(ArrayList<Project> projects) {
        DataBaseManager.modifyObjectAttribute(this, "projects", projects);
    }


}
