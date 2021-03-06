package com.service;

import com.domain.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(Long id,User user);
    void delete(Long id);
    List<User> listUsers();
    User userById(Long id);
}
