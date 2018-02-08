package com.cyh.my.service;

import com.cyh.my.entity.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUser();

    public int addUser(User user);
}
