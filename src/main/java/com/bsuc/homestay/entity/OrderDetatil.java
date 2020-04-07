package com.bsuc.homestay.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账单明细表
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderDetatil implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账单编号
     */
    @TableId(value = "ACCOUNT_ID", type = IdType.AUTO)
    private Integer accountId;

    /**
     * 订单编号
     */
    @TableField("BOOKING_ID")
    private Integer bookingId;

    /**
     * 应收金额
     */
    @TableField("TOTLE_PRICE")
    private BigDecimal totlePrice;

    /**
     * 实收金额
     */
    @TableField("HAS_PRICE")
    private BigDecimal hasPrice;

    /**
     * 优惠金额
     */
    @TableField("DISCOUNTED_PRICE")
    private BigDecimal discountedPrice;

    /**
     * 状态
     */
    @TableField("STUTAS")
    private String stutas;

    /**
     * 创建人
     */
    @TableField(value = "CREATED_BY", fill = FieldFill.INSERT)
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField("CREATED_TIME")
    private Date createdTime;

    /**
     * 更新人
     */
    @TableField(value = "UPDATED_BY", fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    @TableField("IS_DELETE")
    private String isDelete;


}
