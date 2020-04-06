package com.bsuc.homestay.utils;

import java.util.HashMap;

/**
 * 前后端分离
 * 前端数据调用的接口
 * Author： yyhuang
 * Date：2020/4/6 0006
 */
public class RestResponse extends HashMap<String, Object> {
    public static RestResponse success() {
        return success("成功");
    }

    public static RestResponse success(String message) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(true);
        restResponse.setMessage(message);
        restResponse.setCode(0);
        return restResponse;
    }

    public static RestResponse failure(String message) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(false);
        restResponse.setMessage(message);
        restResponse.setCode(0);
        return restResponse;
    }

    //请求成功的方法
    public RestResponse setSuccess(Boolean success) {
       if(success != null)
           put("success",success);
        return this;
    }

    //返回的消息
    public RestResponse setMessage(String message) {
        if(message != null)
            put("message",message);
        return this;
    }

    //返回状态码
    public RestResponse setCode(Object code) {
        if(code != null)
            put("code",code);
        return this;
    }

    //设置当前页
    public RestResponse setCurrentPage(Integer currentPage) {
        if(currentPage != null)
            put("currentPage",currentPage);
        return this;
    }

    //设置页大小
    public RestResponse setLimit(Integer limit) {
        if(limit != null)
            put("limit",limit);
        return this;
    }

    //设置总页数
    public RestResponse setTotal(Long total) {
        if(total != null)
            put("total",total);
        return this;
    }

    //设置任何类型数据,通过键值对的形式保存
    public RestResponse setAny(String key,Object value) {
        if(key != null && value != null)
            put(key,value);
        return this;
    }
}
