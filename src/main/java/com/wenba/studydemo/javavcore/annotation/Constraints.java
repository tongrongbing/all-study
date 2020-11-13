package com.wenba.studydemo.javavcore.annotation;

import java.lang.annotation.*;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/30 3:58 下午
 * @description：
 */
@Documented
@Target(ElementType.FIELD)//只能应用在字段上
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    //判断是否作为主键约束
    boolean primaryKey() default false;
    //判断是否允许为null
    boolean allowNull() default false;
    //判断是否唯一
    boolean unique() default false;

}
