package com.dao;

import com.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{


    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    @Transactional
    public void update(Long id, User user) {
        User getUser = userById(id);
        getUser.setFirstName(user.getFirstName());
        getUser.setLastName(user.getLastName());
        getUser.setEmail(user.getEmail());
        sessionFactory.getCurrentSession().update(getUser);
    }
    @Transactional
    public void delete(Long id) {
        sessionFactory.getCurrentSession().delete(userById(id));
    }
    @Transactional
    public List<User> listUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
    @Transactional
    public User userById(Long id) {
        return (User)sessionFactory.getCurrentSession().createQuery("from User as u where u.id =:id").
                setParameter("id" ,id).getSingleResult();
    }
}
