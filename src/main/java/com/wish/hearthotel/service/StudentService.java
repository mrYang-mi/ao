package com.wish.hearthotel.service;

import com.wish.hearthotel.entities.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangazhang
 * @since 2020-05-29
 */
public interface StudentService extends IService<Student> {
    public Map login(String username, String password);
    public List getDorms(Map map);
}

