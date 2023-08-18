package com.articleapp.dao;

import com.articleapp.model.User;

public interface UserDao {
    void register(User user);
    User getUser(String username, String password);
}
