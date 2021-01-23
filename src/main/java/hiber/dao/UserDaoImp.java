package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    public User getForCar(String model, int series) {

        Car car = (Car) sessionFactory.getCurrentSession().createQuery("FROM Car where model = :model and series = :series")
                .setParameter("model", model)
                .setParameter("series", series)
                .getSingleResult();

        return (User) sessionFactory.openSession().createQuery("FROM User where car = :car")
                .setParameter("car", car)
                .getSingleResult();
    }
}
