package com.bsuc.homestay.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * mybatis自定义自动填充字段
 * Author： yyhuang
 * Date：2020/4/11 0011
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyMetaObjectHandler.class);

    /**
     * 插入自动填充时间
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ...");
        boolean createTime = metaObject.hasSetter("createTime");
//        Object createTime = getFieldValByName("createTime", metaObject);
        if (createTime){
            setFieldValByName("createTime", new Date(), metaObject);
        }

        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (updateTime == null){
            setFieldValByName("updateTime", new Date(), metaObject);
        }
//
//        this.setFieldValByName("createTime", new Date(), metaObject);
//        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    /**
     * 修改自动填充时间
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.info("start updateFill ...");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
