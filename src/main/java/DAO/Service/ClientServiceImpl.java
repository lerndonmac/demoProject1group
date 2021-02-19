package DAO.Service;

import DAO.DAO;
import model.ClientServicePOJO;
import model.Clients;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ClientServiceImpl implements DAO<ClientServicePOJO, Integer> {
    final SessionFactory factory;

    public ClientServiceImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(ClientServicePOJO clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(clientService);
            session.getTransaction().commit();
        }
    }
    @Override
    public ClientServicePOJO read(Integer integer) {
        try (Session session = factory.openSession()){

            return session.get(ClientServicePOJO.class , integer);
        }
    }
    @Override
    public List<ClientServicePOJO> readAll() {
        try (Session session = factory.openSession()){
            String hql = "FROM ClientServicePOJO ";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void update(ClientServicePOJO clientService) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(clientService);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(ClientServicePOJO clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(clientService);
            session.getTransaction().commit();
        }

    }
}
