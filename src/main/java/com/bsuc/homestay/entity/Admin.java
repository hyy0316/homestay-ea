package com.bsuc.homestay.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Admin implements Serializable {

//    private static final long serialVersionUID = 1L;

    /**
     * 管理员编号
     */
    private Integer adminId;

    /**
     * 用户名
     */
    @TableField("ADMIN_USERNAME")
    private String adminUsername;

    /**
     * 密码
     */
    @TableField("ADMIN_PASSWORD")
    private String adminPassword;

    /**
     * 姓名
     */
    @TableField("ADMIN_NAME")
    private String adminName;

    /**
     * 手机号码
     */
    @TableField("ADMIN_PHONE")
    private String adminPhone;

    /** 是否删除 *///逻辑删除字段
    @TableLogic
    @TableField("IS_DELETE")
    private Integer isDelete;

    /**
     * 乐观锁
     */
    @Version
    @TableField("REVISION")
    private Integer revision;

    /**
     * 创建人
     */
    @TableField(value = "CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(value ="CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;

    /**
     * 更新人
     */
    @TableField(value = "UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField(value ="UPDATED_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
