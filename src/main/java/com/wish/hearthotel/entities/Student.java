package com.wish.hearthotel.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangazhang
 * @since 2020-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Student implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    private String pass;

    private String dorm;

    private String coll;

    private String  classes;

    private Integer age;

    private String tel;


}
