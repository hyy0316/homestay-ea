package com.bsuc.homestay.base;

import lombok.Data;

/**
 * 向前端返回信息封装
 * Author： yyhuang
 * Date：2020/4/8 0008
 */
@Data
public class Result<T> {
    //返回信息
    private String msg;
    //数据是否正常请求
    private boolean success;
    //具体返回的数据
    private T detail;

}
