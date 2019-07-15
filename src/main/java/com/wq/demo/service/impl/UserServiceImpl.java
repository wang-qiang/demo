package com.wq.demo.service.impl;

import com.wq.demo.dao.UserDao;
import com.wq.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

}
