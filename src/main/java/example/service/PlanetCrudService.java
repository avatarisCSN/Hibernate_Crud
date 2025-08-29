package example.service;

import example.dao.ClientDao;
import example.dao.PlanetDao;
import example.model.Client;
import example.model.Planet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class PlanetCrudService {
    private final PlanetDao dao = new PlanetDao();

    public void addPlanet(String id, String name) {
        Planet c = new Planet();
        c.setId(id);
        c.setName(name);
        dao.save(c);
    }

    public List<Planet> getAllPlanets() {
        return dao.findAll();
    }

    public Planet getPlanetById(String id) {
        return dao.findById(id);
    }

    public void updatePlanetById(String id, String name) {
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);
        dao.update(planet);
    }

    public void deletePlanetById(String id) {
        dao.delete(id);
    }

}