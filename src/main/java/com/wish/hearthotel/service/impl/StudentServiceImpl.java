package com.wish.hearthotel.service.impl;

import com.wish.hearthotel.entities.Student;
import com.wish.hearthotel.mapper.StudentMapper;
import com.wish.hearthotel.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangazhang
 * @since 2020-05-29
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
