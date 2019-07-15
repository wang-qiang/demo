package com.wq.demo.ctrl;

import com.wq.demo.config.SystemConstant;
import com.wq.demo.dao.UserDao;
import com.wq.demo.repo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexCtrl {

    @Autowired
    UserDao userDao;

    @GetMapping("/")
    public Object index() {
        return userDao.findAll();
    }

    @GetMapping("/healthy")
    public String healthy() {
        return "ok";
    }

    @GetMapping("/version")
    public String version() {
        return SystemConstant.SYS_VERSION;
    }

    @PostMapping(value = "/user/save")
    public User index(User user) {
        Long id = user.getId();
        if (id != null && id > 0L) {
            User one = userDao.getOne(id);
            if (one != null) {
                one.setName(user.getName());
                one.setPassword(user.getPassword());
                return userDao.save(one);
            }
        }

        return userDao.save(user);
    }
}
