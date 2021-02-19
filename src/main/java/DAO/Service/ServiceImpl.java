package DAO.Service;

import DAO.DAO;
import model.ClientServicePOJO;
import model.ServicePOJO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceImpl implements DAO<ServicePOJO, Integer> {
    final SessionFactory factory;

    public ServiceImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(ServicePOJO Service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(Service);
            session.getTransaction().commit();
        }
    }
    @Override
    public ServicePOJO read(Integer integer) {
        try (Session session = factory.openSession()){

            return session.get(ServicePOJO.class , integer);
        }
    }
    @Override
    public List<ServicePOJO> readAll() {
        try (Session session = factory.openSession()){
            String hql = "FROM ServicePOJO ";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void update(ServicePOJO Service) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(Service);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(ServicePOJO Service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(Service);
            session.getTransaction().commit();
        }

    }
}
