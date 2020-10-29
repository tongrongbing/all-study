package com.wenba.studydemo.javavcore.enums;


/**
 * @author：tongrongbing
 * @date：created in 2020/10/29 5:51 下午
 * @description：
 */
public enum ResponseCodeEnum {

    Not_find(404,"not find"),
    ERROR(500,"error");

    public Integer code;
    public String message;

    //私有构造函数
    ResponseCodeEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }


}
