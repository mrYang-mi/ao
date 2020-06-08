package com.wish.hearthotel.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wish.hearthotel.entities.Outstandingdormitory;
import com.wish.hearthotel.entities.Repairs;
import com.wish.hearthotel.entities.Student;
import com.wish.hearthotel.service.NoticeService;
import com.wish.hearthotel.service.OutstandingdormitoryService;
import com.wish.hearthotel.service.RepairsService;
import com.wish.hearthotel.service.StudentService;
import com.wish.hearthotel.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private RepairsService repairsService;
    @Autowired
    private NoticeService noticeService;
    @Autowired(required = true)
    private OutstandingdormitoryService outstandingdormitoryService ;
    //登录
    @ResponseBody
    @PostMapping(value="/loginstudent")
    public ResultBean loginstudent(HttpServletRequest request){
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
    @RequestMapping(value="/")
    public String login(){
        return "/login/studentlogin";
    }
    //宿舍查询
    @ResponseBody
    @GetMapping(value="/getDorm")
    public ResultBean getDorm(HttpServletRequest request){
        HttpSession session=request.getSession();
       Map<String,Object> map = (Map<String, Object>) session.getAttribute("username");
        return  new ResultBean<>(studentService.getDorms(map));
    }
//公告查询
    @ResponseBody
    @GetMapping(value="/getNotice")
    public ResultBean<List> getNotice(){
        return  new ResultBean<List>(noticeService.list()) ;
    }
    //报修查询
    @ResponseBody
    @GetMapping(value="/getrepairs")
    public ResultBean getrepairs(HttpServletRequest request){
        HttpSession session=request.getSession();
        Map<String,Object> map = (Map<String, Object>) session.getAttribute("username");
        QueryWrapper<Repairs> wrapper=new QueryWrapper<>();
        wrapper.eq("repairstudentno",map.get("name"));
        return new ResultBean<List> (repairsService.list(wrapper));
    }

    //报修
    @ResponseBody
    @PostMapping(value="/setrepairs")
    public ResultBean setrepairs(HttpServletRequest request){
        String repairstudentno=request.getParameter("repairstudentno");
        String situation=request.getParameter("situation");
        Date time=new Date();
        Repairs repairs=new Repairs();
        repairs.setRepairstudentno(repairstudentno);
        repairs.setSituation(situation);
        repairs.setTime(String.format(time.toString(),"yyyy-MM-dd "));
        return new ResultBean<>(repairsService.save(repairs) ? 0:1);
    }
    //文明宿舍查询
    @ResponseBody
    public ResultBean getOutstandingdormitory(){
        return  new ResultBean<>(outstandingdormitoryService.list());
    }

    //文明宿舍上传
    @ResponseBody
    public ResultBean setOutstandingdormitory(HttpServletRequest request){
       String dormitory= request.getParameter("dormitory");
        Outstandingdormitory  outstandingdormitory=new Outstandingdormitory();
        outstandingdormitory.setDormitory(dormitory);
        return  new ResultBean<>(outstandingdormitoryService.save(outstandingdormitory) ? 0:1);
    }

}

