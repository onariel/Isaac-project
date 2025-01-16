package isaac.isep.isaacproject;

import isaac.isep.isaacproject.Apiconector.PostgresqlManager;
import isaac.isep.isaacproject.Backend.Employee;
import isaac.isep.isaacproject.Backend.Project;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;



public class RunApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RunApplication.class.getResource("login-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 640);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        PostgresqlManager postgresqlManager = new PostgresqlManager();
        Employee employee = postgresqlManager.getEmployeeByEmail("Lea@gmail.com");
        System.out.println(employee);
        Date date = new Date();
        date.setTime(date.getTime() + 24 * 60 * 60 * 1000);
        Project project =  postgresqlManager.createProject("test", "test", date, date,false,employee,800000);
        System.out.println(project.getName());
    }
}