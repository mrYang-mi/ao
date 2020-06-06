package com.wish.hearthotel.controller;


import com.wish.hearthotel.service.ServiceService;
import com.wish.hearthotel.service.StudentService;
import com.wish.hearthotel.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangazhang
 * @since 2020-05-29
 */
@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping(value = "/login")
    public ResultBean login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (serviceService.login(username, password) == null) {
            return new ResultBean<>(1);
        } else {
            HttpSession userSession = request.getSession();
            userSession.setAttribute("username", serviceService.login(username, password));
            return new ResultBean<>(0);
        }


    }
}

