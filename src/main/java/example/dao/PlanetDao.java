package example.dao;

import example.model.Client;
import example.model.Planet;
import example.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PlanetDao {


    // CREATE
    public void save(Planet planet) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(planet);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // READ by id
    public Planet findById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(Planet.class, id);
        } finally {
            em.close();
        }
    }

    // READ all
    public List<Planet> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
        } finally {
            em.close();
        }
    }

    // UPDATE
    public void update(Planet planet) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(planet);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // DELETE
    public void delete(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Planet planet = em.find(Planet.class, id);
            if (planet != null) {
                em.remove(planet);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}