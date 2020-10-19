package com.wenba.studydemo.designpattern.proxy.dynamic;

import com.wenba.studydemo.designpattern.proxy.service.UserService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/19 2:43 下午
 * @description：
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Class<?> proxyClass = Proxy.getProxyClass(UserService.class.getClassLoader(), UserService.class);
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        UserService userServiceProxy = (UserService)constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("==========");
                return null;
            }
        });
        userServiceProxy.update();
    }
}
