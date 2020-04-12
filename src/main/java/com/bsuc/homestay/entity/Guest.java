package com.bsuc.homestay.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户编号
     */
    @TableId(value = "GUEST_ID", type = IdType.AUTO)
    private Integer guestId;

    /**
     * 手机号码
     */
    @TableField("GUEST_PHONE")
    private String guestPhone;

    /**
     * 姓名
     */
    @TableField("GUEST_NAME")
    private String guestName;

    /**
     * 性别
     */
    @TableField("GUEST_SEX")
    private String guestSex;

    /**
     * 身份证号码
     */
    @TableField("GUEST_IDCARD")
    private String guestIdcard;

    /**
     * 昵称
     */
    @TableField("GUEST_USERNAME")
    private String guestUsername;

    /**
     * 密码
     */
    @TableField("GUEST_PASSWORD")
    private String guestPassword;

    /**
     * 客户等级
     */
    @TableField("GUEST_GRADE")
    private Integer guestGrade;

    /**
     * 入住次数
     */
    @TableField("GUEST_CHECKINTIMES")
    private Integer guestCheckintimes;

    /**
     * 消费总金额
     */
    @TableField("GUEST_CONSUMPTION")
    private BigDecimal guestConsumption;

    /** 是否删除 */
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
     * 更新时间
     */
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    /**
     * 创建时间
     */
    @TableField(value ="CREATED_TIME",fill = FieldFill.INSERT)
    private Date createdTime;


}
