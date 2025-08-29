package example;

import example.model.Client;
import example.model.Planet;
import example.service.ClientCrudService;
import example.service.PlanetCrudService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.flywaydb.core.Flyway;

public class Main {






    public static void main(String[] args) {

        // 1. Прогоняем миграции
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/jdbc_hiber", "root", "asdfgh665599")
                .load();
        flyway.migrate();

        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();

        // --- Client ---

        clientService.addClient("Jonni Cina");

        System.out.println("All clients: " + clientService.getAllClients().toString());


        clientService.updateClientById(6L, "Honney Silk");
        System.out.println("Updated client: " + clientService.getClientById(6L));

        clientService.deleteClientById(6L);
        System.out.println("All clients: " + clientService.getAllClients().toString());

      // planet
        planetService.addPlanet("MARS4", "Marsianka");

        System.out.println("All planets: " + planetService.getAllPlanets().toString());


        planetService.updatePlanetById("MARS4", "Marsey-happy");
        System.out.println("Updated planet: " + planetService.getPlanetById("MARS4"));

        planetService.deletePlanetById("MARS4");
        System.out.println("All clients: " + planetService.getAllPlanets().toString());


    }
}