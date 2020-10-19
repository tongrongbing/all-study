package com.wenba.studydemo.designpattern.proxy.dynamic;

import com.wenba.studydemo.designpattern.proxy.service.UserServiceImpl;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/19 5:47 下午
 * @description：
 */
public class UserServiceDynamicProxyTest2 {
    public static void main(String[] args) throws Exception{
        UserServiceImpl userService = new UserServiceImpl();
        ClassLoader classLoader = userService.getClass().getClassLoader();
        System.out.println("classLoader" + classLoader);
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        for (int i = 0; i < interfaces.length ; i++) {
            String name = interfaces[i].getName();
            System.out.println(name);
            Class<?> interfaceClass = Class.forName(name, false, classLoader);
            System.out.println(interfaceClass == interfaces[i]);
        }
    }
}
