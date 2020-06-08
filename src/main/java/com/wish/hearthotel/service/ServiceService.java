package com.wish.hearthotel.service;

import com.wish.hearthotel.entities.Service;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangazhang
 * @since 2020-05-29
 */
public interface ServiceService extends IService<Service> {
    public Map login(String username, String password);
}
