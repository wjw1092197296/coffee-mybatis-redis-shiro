package com.my.coffee.controller;

import com.my.coffee.dao.UserDao;
import com.my.coffee.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: wangjw
 * @Date: 2019/8/13 10:51
 * @Description:用户
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;
    @GetMapping("/getUserById")
    @ResponseBody
    public String getUserById(int id){
        User u = userDao.findById(id);
        return "heloo";
    }

    @GetMapping("/save")
    @ResponseBody
    public String myModel(String name){
        User user =new User();
        user.setName(name).setId(11);
        userDao.save(user);
        return "heloo";
    }

}
