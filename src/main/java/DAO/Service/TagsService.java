package DAO.Service;

import DAO.DAO;
import model.TagsPOJO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TagsService implements DAO<TagsPOJO, Integer> {
    final SessionFactory factory;

    public TagsService(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(TagsPOJO Service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(Service);
            session.getTransaction().commit();
        }
    }
    @Override
    public TagsPOJO read(Integer integer) {
        try (Session session = factory.openSession()){

            return session.get(TagsPOJO.class , integer);
        }
    }
    @Override
    public List<TagsPOJO> readAll() {
        try (Session session = factory.openSession()){
            String hql = "FROM TagsPOJO ";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void update(TagsPOJO Service) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(Service);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(TagsPOJO Service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(Service);
            session.getTransaction().commit();
        }

    }
}
