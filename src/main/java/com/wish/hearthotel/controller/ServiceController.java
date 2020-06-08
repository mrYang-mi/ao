package com.wish.hearthotel.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wish.hearthotel.entities.Repairs;
import com.wish.hearthotel.entities.Student;
import com.wish.hearthotel.service.RepairsService;
import com.wish.hearthotel.service.ServiceService;
import com.wish.hearthotel.service.StudentService;
import com.wish.hearthotel.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private RepairsService repairsService;
    @ResponseBody
    @PostMapping (value = "/login")
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
    @RequestMapping(value="/")
    public String loginPage(){
        return "/login/Servicelogin";
    }
    //报修查询
    @ResponseBody
    @GetMapping(value="/getrepairs")
    public List getrepairs(){
        return repairsService.list();
    }
    //报修完成
    @ResponseBody
    @PostMapping(value="/setrepairs")
    public ResultBean setrepairs(HttpServletRequest request){
        String repairstudentno=request.getParameter("repairstudentno");
        String situation=request.getParameter("situation");
        int  id=Integer.parseInt(request.getParameter("id"));
        int  servicepeople=Integer.parseInt(request.getParameter("servicepeople"));
        String time=String.format(request.getParameter("time"),"yyyy-MM-dd ");
        Repairs repairs=new Repairs();
        repairs.setRepairstudentno(repairstudentno);
        repairs.setSituation(situation);
        repairs.setId(id);
        repairs.setServicepeople(servicepeople);
        repairs.setTime(time);
        QueryWrapper<Repairs> wrapper=new QueryWrapper<>();
        wrapper.eq("repairstudentno",repairstudentno);
        return new ResultBean<>(repairsService.update(repairs,wrapper)? 0:1);
    }
}

