package com.cyh.my.dao;

import com.cyh.core.dao.impl.DaoImpl;
import com.cyh.my.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao extends DaoImpl<User, Integer> {

}
