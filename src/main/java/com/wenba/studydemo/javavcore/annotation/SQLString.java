package com.wenba.studydemo.javavcore.annotation;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/30 6:04 下午
 * @description：
 */
public @interface SQLString {

    //对应数据库表的列名
    String name() default "";

    //列类型分配的长度，如varchar(30)的30
    int value() default 0;

    Constraints constraint() default @Constraints;
}
