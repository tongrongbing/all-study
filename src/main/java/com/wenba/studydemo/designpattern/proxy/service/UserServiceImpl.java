package com.wenba.studydemo.designpattern.proxy.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/19 1:59 下午
 * @description：
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService, Cloneable , Serializable {
    @Override
    public int update() {
        System.out.println("更新用户信息...");
        return 110119120;
    }
}
