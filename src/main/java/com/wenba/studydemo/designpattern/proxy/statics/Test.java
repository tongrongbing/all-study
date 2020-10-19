package com.wenba.studydemo.designpattern.proxy.statics;

import com.wenba.studydemo.designpattern.proxy.service.UserService;
import com.wenba.studydemo.designpattern.proxy.service.UserServiceImpl;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/19 2:06 下午
 * @description：
 */
public class Test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserServiceStaticProxy proxy = new  UserServiceStaticProxy(userService);
        proxy.update();
    }
}
