package isaac.isep.isaacproject.Apiconector;


import isaac.isep.isaacproject.Apiconector.RequestLogin;
import isaac.isep.isaacproject.Backend.Employee;
import isaac.isep.isaacproject.Backend.Project;
import isaac.isep.isaacproject.Backend.Task;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PostgresqlManager {

    private final String BASE_URL = "http://localhost:8081";
    private final RestTemplate restTemplate = new RestTemplate();

    // Employee API Calls

    public Employee createEmployee(String name, String email, String password, String role) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setRole(role);
        employee.setPassword(password);
        ResponseEntity<Long> response = restTemplate.postForEntity(BASE_URL + "/Employee/create", employee, Long.class);
        employee.setId(response.getBody());
        return employee;
    }

    public Project createProject(String name, String description, Date startDate, Date endDate, Boolean status, Employee projectManager, float budget) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setStatus(status);
        project.setProjectManager(projectManager);
        project.setBudget(budget);
        System.out.println(project);
        ResponseEntity<Long> response = restTemplate.postForEntity(BASE_URL + "/Project/create", project, Long.class);
        project.setId(response.getBody());
        return project;
    }

    public Project createTask(String name, String description, int priority, Date dueDate, Boolean status, Project project, float budget) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setPriority(priority);
        task.setDueDate(dueDate);
        task.setStatus(status);
        task.setProject(project);
        task.setBudget(budget);
        ResponseEntity<Long> response = restTemplate.postForEntity(BASE_URL + "/Task/create", task, Long.class);
        project.setId(response.getBody());
        return project;
    }

    public Long Login(String email, String password) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Définit application/json

        RequestLogin requestLogin = new RequestLogin(email, password);

        ResponseEntity<Long> response = restTemplate.postForEntity("http://localhost:8080/Employee/login", requestLogin, Long.class);
        System.out.println(response.getBody());
        return response.getBody();
    }

    public Employee getEmployeeByEmail(String email) {
        ResponseEntity<Employee> response = restTemplate.getForEntity(BASE_URL + "/Employee/byEmail?email=" + email, Employee.class);
        return response.getBody();
    }

    public String getEmployeeName(long id) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/Employee/" + id + "/name", String.class);
        return response.getBody();
    }

    public void setEmployeeName(long id, String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(name, headers);
        restTemplate.postForEntity(BASE_URL + "/Employee/" + id + "/name", request, String.class);
    }

    public String getEmployeeEmail(long id) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/Employee/" + id + "/email", String.class);
        return response.getBody();
    }

    public void setEmployeeEmail(long id, String email) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(email, headers);
        restTemplate.postForEntity(BASE_URL + "/Employee/" + id + "/email", request, String.class);
    }

    public String getEmployeeRole(long id) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/Employee/" + id + "/role", String.class);
        return response.getBody();
    }


    public void setEmployeeRole(long id, String role) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(role, headers);
        restTemplate.postForEntity(BASE_URL + "/Employee/" + id + "/role", request, String.class);
    }

    // Project API Calls

    public String getProjectName(long id) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/Project/" + id + "/name", String.class);
        return response.getBody();
    }

    public void setProjectName(long id, String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(name, headers);
        restTemplate.postForEntity(BASE_URL + "/Project/" + id + "/name", request, String.class);
    }

    public String getProjectDescription(long id) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/Project/" + id + "/description", String.class);
        return response.getBody();
    }

    public void setProjectDescription(long id, String description) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(description, headers);
        restTemplate.postForEntity(BASE_URL + "/Project/" + id + "/description", request, String.class);
    }

    public Date getProjectStartDate(long id) {
        ResponseEntity<Date> response = restTemplate.getForEntity(BASE_URL + "/Project/" + id + "/startDate", Date.class);
        return response.getBody();
    }


    public void setProjectStartDate(long id, Date startDate) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Date> request = new HttpEntity<>(startDate, headers);
        restTemplate.postForEntity(BASE_URL + "/Project/" + id + "/startDate", request, Date.class);
    }

    public Date getProjectEndDate(long id) {
        ResponseEntity<Date> response = restTemplate.getForEntity(BASE_URL + "/Project/" + id + "/endDate", Date.class);
        return response.getBody();
    }

    public void setProjectEndDate(long id, Date endDate) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Date> request = new HttpEntity<>(endDate, headers);
        restTemplate.postForEntity(BASE_URL + "/Project/" + id + "/endDate", request, Date.class);
    }

    public Boolean getProjectStatus(long id) {
        ResponseEntity<Boolean> response = restTemplate.getForEntity(BASE_URL + "/Project/" + id + "/status", Boolean.class);
        return response.getBody();
    }

    public void setProjectStatus(long id, Boolean status) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Boolean> request = new HttpEntity<>(status, headers);
        restTemplate.postForEntity(BASE_URL + "/Project/" + id + "/status", request, Boolean.class);
    }


    public Float getProjectBudget(long id) {
        ResponseEntity<Float> response = restTemplate.getForEntity(BASE_URL + "/Project/" + id + "/budget", Float.class);
        return response.getBody();
    }
    public void setProjectBudget(long id, Float budget) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Float> request = new HttpEntity<>(budget, headers);
        restTemplate.postForEntity(BASE_URL + "/Project/" + id + "/budget", request, Float.class);
    }


    // Task API Calls
    public String getTaskName(long id) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/Task/" + id + "/name", String.class);
        return response.getBody();
    }
    public void setTaskName(long id, String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(name, headers);
        restTemplate.postForEntity(BASE_URL + "/Task/" + id + "/name", request, String.class);
    }


    public String getTaskDescription(long id) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/Task/" + id + "/description", String.class);
        return response.getBody();
    }

    public void setTaskDescription(long id, String description) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(description, headers);
        restTemplate.postForEntity(BASE_URL + "/Task/" + id + "/description", request, String.class);
    }

    public Integer getTaskPriority(long id) {
        ResponseEntity<Integer> response = restTemplate.getForEntity(BASE_URL + "/Task/" + id + "/priority", Integer.class);
        return response.getBody();
    }

    public void setTaskPriority(long id, Integer priority) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Integer> request = new HttpEntity<>(priority, headers);
        restTemplate.postForEntity(BASE_URL + "/Task/" + id + "/priority", request, Integer.class);
    }


    public Date getTaskDueDate(long id) {
        ResponseEntity<Date> response = restTemplate.getForEntity(BASE_URL + "/Task/" + id + "/dueDate", Date.class);
        return response.getBody();
    }

    public void setTaskDueDate(long id, Date dueDate) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Date> request = new HttpEntity<>(dueDate, headers);
        restTemplate.postForEntity(BASE_URL + "/Task/" + id + "/dueDate", request, Date.class);
    }

    public Boolean getTaskStatus(long id) {
        ResponseEntity<Boolean> response = restTemplate.getForEntity(BASE_URL + "/Task/" + id + "/status", Boolean.class);
        return response.getBody();
    }

    public void setTaskStatus(long id, Boolean status) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Boolean> request = new HttpEntity<>(status, headers);
        restTemplate.postForEntity(BASE_URL + "/Task/" + id + "/status", request, Boolean.class);
    }
    public Float getTaskBudget(long id) {
        ResponseEntity<Float> response = restTemplate.getForEntity(BASE_URL + "/Task/" + id + "/budget", Float.class);
        return response.getBody();
    }
    public void setTaskBudget(long id, Float budget) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Float> request = new HttpEntity<>(budget, headers);
        restTemplate.postForEntity(BASE_URL + "/Task/" + id + "/budget", request, Float.class);
    }

    public boolean addEmployee(long id, String email) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(email, headers);
        ResponseEntity<Boolean> response  = restTemplate.postForEntity(BASE_URL + "/Employee/" + id + "/add", request, Boolean.class);
        return Boolean.TRUE.equals(response.getBody());
    }

    public List<Project> getProjects(long id) {
        ResponseEntity<List> response = restTemplate.getForEntity(BASE_URL + "/Project/" + id, List.class);
        return response.getBody();
    }
}