package com.wenba.studydemo.designpattern.proxy.reflection;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/19 4:21 下午
 * @description：
 */
public class ReflectionVersion1 {
    public static void main(String[] args) throws Exception{
        // 创建Class类对象
       /* Student student = new Student();
        Class aClass1 = student.getClass();*/
        Class aClass2 = Student.class;

        Student student2 = (Student) aClass2.newInstance(); // 利用aClass2.newInstance()创建实例对象需要 Student类中无参数构造函数

        Class<?> aClass3 = Class.forName("com.wenba.studydemo.designpattern.proxy.reflection.Student");
        // 获取共有的指定类型的构造器
        Constructor<?> constructor = aClass3.getConstructor(String.class, int.class);
        Student student = (Student) constructor.newInstance("chen", 10);
        System.out.println(student);

        // 获取无参数构造器
        Constructor<?> constructor1 = aClass3.getConstructor();
        Object o = constructor1.newInstance();
        System.out.println("=======无参数构造器======"+o);

        // 获取私有的指定类型的构造器
        Constructor<?> declaredConstructor = aClass3.getDeclaredConstructor(int.class);
        System.out.println(declaredConstructor);
        // 使用私有的构造器方式
        declaredConstructor.setAccessible(true);
        System.out.println(declaredConstructor.newInstance(10));

        // 获取指定的私有方法
        Method run = aClass3.getDeclaredMethod("play");
        System.out.println(run);
        // 私用的访问需要加上 setAccessible(true);
        run.setAccessible(true);
        run.invoke(student);
        Resource resource = run.getAnnotation(Resource.class);
        System.out.println("method description" + resource.description());


        // 获取指定的静态方法
        Method execute = aClass3.getDeclaredMethod("execute", char.class);
        execute.invoke(null,'t');

        // 获取注解
        Service annotation = aClass3.getAnnotation(Service.class);
        String value = annotation.value();
        System.out.println("注解的值为：" + value);

        // 反射简单应用 利用反射越过集合泛型参数校验
        List<String> list = new ArrayList<>();
        list.add("aaaaa");
        list.add("ccccc");
        Class<? extends List> aClass = list.getClass();
        Method method = aClass.getMethod("add", Object.class);
        method.invoke(list,120100);
        Object res = list.get(2);  // 以Object类型接收数据
        System.out.println(res); // 输出 120100


    }
}
