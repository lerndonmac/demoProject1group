package DAO.Service;

import DAO.DAO;
import com.mysql.cj.jdbc.ConnectionImpl;
import model.Clients;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.util.List;

public class ClientsService implements DAO<Clients, Integer> {
    final SessionFactory factory;

    public ClientsService(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Clients clients) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(clients);
            session.getTransaction().commit();
        }
    }
    @Override
    public Clients read(Integer integer) {
        try (Session session = factory.openSession()){

            return session.get(Clients.class , integer);
        }
    }
    @Override
    public List<Clients> readAll() {
        try (Session session = factory.openSession()){
            String hql = "FROM Clients ";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void update(Clients clients) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(clients);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Clients clients) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(clients);
            session.getTransaction().commit();
        }

    }
}
