package com.wish.hearthotel.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.wish.hearthotel.entities.Student;
import com.wish.hearthotel.service.StudentService;
import com.wish.hearthotel.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangazhang
 * @since 2020-05-29
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping(value="/login")
    public ResultBean login(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
            if(studentService.login(username,password)==null){
                return new ResultBean<>(1);
        }else{
             HttpSession userSession= request.getSession();
             userSession.setAttribute("username",studentService.login(username,password));
                return  new ResultBean<>(0);
            }
    }
    @GetMapping(value="/getDorm")
    public List getDorm(HttpServletRequest request){
        HttpSession session=request.getSession();
       Map<String,Object> map = (Map<String, Object>) session.getAttribute("username");
        return studentService.getDorms(map);
    }

    @GetMapping(value="/getDorm")
    public List getNotice(){
        return null;
    }
}

