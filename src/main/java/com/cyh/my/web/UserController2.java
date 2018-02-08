package com.cyh.my.web;

import com.alibaba.fastjson.JSON;
import com.cyh.my.entity.User;
import com.cyh.my.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController2 {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/user/list", produces = "text/json;charset=utf-8")
    @ResponseBody
    public String list(Model model) {
        List<User> allUser = userService.getAllUser();
        return JSON.toJSONString(allUser);
    }
}
