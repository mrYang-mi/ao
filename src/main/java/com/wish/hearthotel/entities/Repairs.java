package com.wish.hearthotel.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Repairs {
    /*
    维修类
     */
    //id属性
    private int id;
    //维修上报学生的学号
    private String repairstudentno;
    //维修人的id
    private int servicepeople;
    //报修情况
    private String situation;
    //时间
    private String time;

}
