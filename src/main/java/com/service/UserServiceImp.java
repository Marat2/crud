package com.service;

import com.domain.User;
import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp  implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void add(User user) {
        userDao.add(user);
    }
    @Transactional
    public void update(Long id, User user) {
        userDao.update(id,user);
    }
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    public List<User> listUsers() {
        return userDao.listUsers();
    }

    public User userById(Long id) {
        return userDao.userById(id);
    }
}
