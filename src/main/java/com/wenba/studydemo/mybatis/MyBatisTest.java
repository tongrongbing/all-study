package com.wenba.studydemo.mybatis;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/16 10:34 上午
 * @description：
 */
public class MyBatisTest {
    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(MyBatisTest.class.getClassLoader(), new Class<?>[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Select annotation = method.getAnnotation(Select.class);
                Map<String, Object> map = getParam(method, args);
                System.out.println(map);
                if (annotation != null){
                String[] value = annotation.value();
                System.out.println(Arrays.toString(value));
            }
                return null;
            }
        });
        userMapper.selectUserList(100,"kangkang");
    }

    public static Map<String,Object> getParam(Method method, Object[] args){
        Map<String,Object> paramMap = new HashMap<>();
        Parameter[] parameters = method.getParameters();
        int index[] = {0};
        Arrays.asList(parameters).forEach(parameter -> {
            String name = parameter.getName();
            paramMap.put(name,args[index[0]]);
            index[0]++;
        });

        return paramMap;
    }


}



interface UserMapper{

    @Select({"select * from user where id = #{id} and name= #{name}"})
    List<User> selectUserList(Integer id,String name);
}

class User{
    int id;
    int name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
