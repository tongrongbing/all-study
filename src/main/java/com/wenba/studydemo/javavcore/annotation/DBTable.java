package com.wenba.studydemo.javavcore.annotation;

import java.lang.annotation.*;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/30 3:51 下午
 * @description：
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DBTable {

    String name() default "";
}
