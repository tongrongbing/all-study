package com.wenba.studydemo.designpattern.proxy.statics;

import com.wenba.studydemo.designpattern.proxy.service.UserService;
import com.wenba.studydemo.designpattern.proxy.service.UserServiceImpl;

import java.util.Date;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/19 2:01 下午
 * @description：
 */
public class UserServiceStaticProxy implements UserService {

    private UserService  userService;

    public UserServiceStaticProxy(UserService  userService){
        this.userService = userService;
    }
    @Override
    public int update() {
        start();
        userService.update();
        end();
        return 111;
    }

    private void start(){
        System.out.println(String.format("开始时间[%s]",new Date()));
    }

    private void end(){
        System.out.println(String.format("结束时间[%s]",new Date()));
    }
}
