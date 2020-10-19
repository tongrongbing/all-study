package com.wenba.studydemo.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/19 2:42 下午
 * @description： 就是通过类加载器加载字节码文件，然后重新生成新的字节码文件，利用新字节码文件创建代理类Class对象
 * 然后在利用Class对象 创建代理实例对象。最后通过代理类实例对象对被代理对象行为的控制和访问。比如被代理对象行为的增强。
 * 其中，Proxy 生成代理类实例对象 ，InvocationHandle处理器回调接口，用来真正委托处理被代理类对象的行为控制。
 */
public class DynamicProxyObject implements InvocationHandler {

    private Object target;

    public DynamicProxyObject(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        start();
        Object res = method.invoke(target, args);
        end();
        return res;
    }

    private void start(){
        System.out.println(String.format("开始时间[%s]",new Date()));
    }

    private void end(){
        System.out.println(String.format("结束时间[%s]",new Date()));
    }
}
