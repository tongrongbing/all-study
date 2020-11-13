package com.wenba.studydemo.javavcore.annotation;

import lombok.NonNull;

/**
 * @author：tongrongbing
 * @date：created in 2020/10/30 6:09 下午
 * @description：
 */
@DBTable(name = "person")
public class Person {

    @SQLString(name = "id",value = 10,constraint = @Constraints(primaryKey = true,unique = true))
    @NonNull
    private String id;

    @SQLString(name = "name" ,value = 20 , constraint = @Constraints(allowNull = true))
    private String name;

    @SQLInteger(name = "age", value = 2 ,constraint = @Constraints(allowNull = true))
    private int age;

}
