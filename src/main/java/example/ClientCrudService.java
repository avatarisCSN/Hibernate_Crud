package example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class ClientCrudService {

    private final EntityManager em;

    public ClientCrudService(EntityManager em) {
        this.em = em;
    }

    public Client create(Client client) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(client);
        tx.commit();
        return client;
    }

    public Client read(int id) {
        return em.find(Client.class, id);
    }

    public List<Client> readAll() {
        return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    public Client update(Client client) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Client updated = em.merge(client);
        tx.commit();
        return updated;
    }

    public void delete(int id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Client client = em.find(Client.class, id);
        if (client != null) {
            em.remove(client);
        }
        tx.commit();
    }
}