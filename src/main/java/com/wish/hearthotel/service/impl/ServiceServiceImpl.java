package com.wish.hearthotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wish.hearthotel.entities.Service;
import com.wish.hearthotel.entities.Student;
import com.wish.hearthotel.mapper.ServiceMapper;
import com.wish.hearthotel.service.ServiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangazhang
 * @since 2020-05-29
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl extends ServiceImpl<ServiceMapper, com.wish.hearthotel.entities.Service> implements ServiceService {

    public String login(String username, String password){
        QueryWrapper<Service> wrapper=new QueryWrapper<>();
        wrapper.eq("name",username).eq("pass",password);
        Map<String,Object> map=this.getMap(wrapper);
        if(map==null){
            return null;
        }
        return String.valueOf(map);
    }
}
