package com.cyh.my.service.impl;

import com.cyh.my.dao.UserDao;
import com.cyh.my.entity.User;
import com.cyh.my.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserService implements IUserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.list();
    }

    @Override
    public int addUser(User user) {
        return userDao.add(user);
    }
}
