package com.wenba.studydemo.javavcore.annotation;

import lombok.NonNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/30 6:17 下午
 * @description：
 */
public class AnnotationTest {
    public static void main(String[] args) throws Exception{

        Class<?> aClass = Class.forName("com.wenba.studydemo.javavcore.annotation.Person");
        DBTable dbTable = aClass.getAnnotation(DBTable.class);
        String tableName = dbTable.name().toLowerCase();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field: fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations){
                if (annotation instanceof SQLInteger){
                    String name = ((SQLInteger) annotation).name();
                    System.out.println(name);
                }
                if (annotation instanceof NonNull){

                }
            }

        }


    }
}
