package com.example.projectSpringBoot.service;

import com.example.projectSpringBoot.dao.UserDao;
import com.example.projectSpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    @Autowired

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void update(long id, User user) {
        userDao.update(id,user);

    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}

