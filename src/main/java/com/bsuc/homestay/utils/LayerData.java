package com.bsuc.homestay.utils;


import lombok.Data;

import java.util.List;

/**
 * layer工具类
 * Author： yyhuang
 * Date：2020/4/6 0006
 */
@Data
public class LayerData<T> {
    private Integer code = 0;

    private Integer count;

    private List<T> data;

    private String msg="";

}
