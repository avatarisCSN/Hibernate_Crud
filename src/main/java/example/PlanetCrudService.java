package example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class PlanetCrudService {

    private final EntityManager em;

    public PlanetCrudService(EntityManager em) {
        this.em = em;
    }

    public Planet create(Planet planet) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(planet);
        tx.commit();
        return planet;
    }

    public Planet read(String id) {
        return em.find(Planet.class, id);
    }

    public List<Planet> readAll() {
        return em.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
    }

    public Planet update(Planet planet) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Planet updated = em.merge(planet);
        tx.commit();
        return updated;
    }

    public void delete(String id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Planet planet = em.find(Planet.class, id);
        if (planet != null) {
            em.remove(planet);
        }
        tx.commit();
    }
}