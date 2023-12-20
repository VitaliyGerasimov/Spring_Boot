package com.example.projectSpringBoot.dao;



import com.example.projectSpringBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    User getUserById(Long id);

    void create(User user);

    void update(long id, User userUpdate);

    void deleteUser(Long id);
}
