package com.wq.demo.ctrl;

import com.wq.demo.config.SystemConstant;
import com.wq.demo.dao.UserDao;
import com.wq.demo.repo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping(value = "/user/save", consumes = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping("/users")
    public List<User> listUsers() {
        return userDao.findAll(Sort.by(Sort.Order.asc("name")));
    }
}
