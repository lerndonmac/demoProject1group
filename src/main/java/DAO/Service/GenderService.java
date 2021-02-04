package DAO.Service;

import DAO.DAO;
import model.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class GenderService implements DAO<Gender, Integer> {
    final SessionFactory factory;

    public GenderService(SessionFactory factory){
        this.factory = factory;
    }
    @Override
    public void create(Gender gender) {

    }

    @Override
    public Gender read(Integer integer) {
        return null;
    }

    @Override
    public List<Gender> readAll() {
        try (Session session = factory.openSession()){
            String hql = "FROM Clients ";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
    }

    @Override
    public void update(Gender gender) {

    }

    @Override
    public void delete(Gender gender) {

    }
}
