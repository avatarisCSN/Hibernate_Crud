package example.service;

import example.dao.ClientDao;
import example.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class ClientCrudService {


        private final ClientDao dao = new ClientDao();

        public void addClient(String name) {
            Client c = new Client();
            c.setName(name);
            dao.save(c);
        }

        public List<Client> getAllClients() {
            return dao.findAll();
        }

        public Client getClientById(Long id) {
            return dao.findById(id);
        }

        public void updateClientById(Long id, String name) {
            Client client = new Client();
            client.setId(id);
            client.setName(name);
            dao.update(client);
        }

        public void deleteClientById(Long id) {
            dao.delete(id);
        }
    }