package DAO.Service;

import DAO.DAO;
import model.Clients;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserService implements DAO<User, Integer> {
    final SessionFactory factory;

    public UserService(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(User clients) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(clients);
            session.getTransaction().commit();
        }
    }
    @Override
    public User read(Integer integer) {
        try (Session session = factory.openSession()){

            return session.get(User.class , integer);
        }
    }
    @Override
    public List<User> readAll() {
        try (Session session = factory.openSession()){
            String hql = "FROM User ";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void update(User clients) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(clients);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(User clients) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(clients);
            session.getTransaction().commit();
        }

    }
}
