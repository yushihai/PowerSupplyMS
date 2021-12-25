package com.ysh.mvc.controller;

import com.ysh.mvc.bean.Manager;
import com.ysh.mvc.dao.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller
public class LoginController {

    @Autowired
    private ManagerDao dao;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginConfirm")
    public String loginConfirm(Manager manager, HttpSession session) throws Exception {

        if(dao.loginConfirm(manager)==true) {
            session.setAttribute("name",manager.getName());
            return "index";
        }
        else
            return "login";
    }

    @RequestMapping("/test")
    public String test(Manager manager) throws Exception {

        return "test";
    }
}