package com.wenba.studydemo.designpattern.proxy.dynamic;

import com.wenba.studydemo.designpattern.proxy.service.UserService;
import com.wenba.studydemo.designpattern.proxy.service.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/19 3:20 下午
 * @description：
 */
public class UserServiceDynamicProxyTest {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        DynamicProxyObject invocation = new DynamicProxyObject(userService);
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(classLoader, interfaces, invocation);
        System.out.println(proxyInstance.update());

    }
}
