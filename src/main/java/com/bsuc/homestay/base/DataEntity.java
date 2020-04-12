package com.bsuc.homestay.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 数据Entity基础类
 * Author： yyhuang
 * Date：2020/4/6 0006
 */

@Data
public abstract class DataEntity <T extends Model> {
    private static final long serialversionUID = 1L;

    public DataEntity() {
    }
    public DataEntity(Long createId) {
        this();
        this.createId = createId;
    }

    /**
     * 创建者
     */
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    protected Long createId;

    /**
     * 创建日期
     */
    @TableField(value = "create_date",fill = FieldFill.INSERT)
    protected Date createDate;

    /**
     * 更新者
     */
    @TableField(value = "update_by",fill = FieldFill.INSERT_UPDATE)
    protected Long updateId;

    /**
     * 更新日期
     */
    @TableField(value = "update_date",fill = FieldFill.INSERT_UPDATE)
    protected Date updateDate;

    @TableField(value = "is_delete")
    protected Boolean isDelete;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }
}
