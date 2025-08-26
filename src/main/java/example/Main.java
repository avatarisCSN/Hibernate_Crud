package example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        ClientCrudService clientService = new ClientCrudService(em);
        PlanetCrudService planetService = new PlanetCrudService(em);

        // --- Client ---
        Client client = new Client();
        client.setName("John Doe");
        clientService.create(client);
        System.out.println("All clients: " + clientService.readAll());

        client.setName("John Updated");
        clientService.update(client);
        System.out.println("Updated client: " + clientService.read(client.getId()));

        clientService.delete(client.getId());
        System.out.println("All clients after delete: " + clientService.readAll());

        // --- Planet ---
        Planet planet = new Planet();
        planet.setId("mars");
        planet.setName("Mars");
        planetService.create(planet);
        System.out.println("All planets: " + planetService.readAll());

        planet.setName("Mars Updated");
        planetService.update(planet);
        System.out.println("Updated planet: " + planetService.read(planet.getId()));

        planetService.delete(planet.getId());
        System.out.println("All planets after delete: " + planetService.readAll());

        em.close();
        emf.close();
    }
}