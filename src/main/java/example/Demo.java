package example;

import example.model.Client;
import example.service.ClientCrudService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.flywaydb.core.Flyway;

import java.util.Arrays;
import java.util.List;




public class Demo {
    public static void main(String[] args) {
        Client client =  new Client();
        client.setId(12L);
        client.setName("boroshka");
        ClientCrudService clientService = new ClientCrudService();

        List<Client> clients = clientService.getAllClients();
        System.out.println(clients);
        System.out.println("Hellooooo " + clients.toString());
    }
}