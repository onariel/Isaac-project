package isaac.isep.isaacproject.Apiconector;

import isaac.isep.isaacproject.Backend.Employee;
import isaac.isep.isaacproject.Backend.Project;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class PostgresqlManager {

    public static Employee Creat_an_Employee(String name, String email, String password, String role) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Définit application/json

        Employee employee = new Employee(name, email, role, password);

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/Employee", employee, String.class);
        employee.setId(Integer.valueOf(response.getBody()));
        return employee;
    }

    public static Boolean Login(String email, String password) {RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Définit application/json

        RequestLogin requestLogin = new RequestLogin(email, password);

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/Employee/login", requestLogin, String.class);
        System.out.println(response.getBody());
        return null;
    }

    //public static Project Creat_a_Project(String name, String description, String location) {}
}

