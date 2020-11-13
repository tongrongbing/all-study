package com.wenba.studydemo.javavcore.annotation;

import java.lang.annotation.*;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/30 3:57 下午
 * @description：
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SQLInteger {

    //该字段对应数据库表列名
    String name() default "";

    int value() default 0;

    //嵌套注解
    Constraints constraint() default @Constraints;

}
