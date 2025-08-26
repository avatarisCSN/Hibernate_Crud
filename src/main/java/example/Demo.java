package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.flywaydb.core.Flyway;

@SpringBootApplication


public class Demo {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/jdbc_hiber?useSSL=false&serverTimezone=UTC", "root", "asdfgh665599")
                .load();

        flyway.migrate();

        System.out.println("Миграции выполнены для MySQL!");
    }
}