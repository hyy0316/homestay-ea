package com.bsuc.homestay.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 预订支付表
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BookingDetatil implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预订详情编号
     */
    @TableId(value = "BOOKING_ID", type = IdType.ID_WORKER_STR)
    private Integer bookingId;

    /**
     * 是否付款
     */
    @TableField("ISPAY")
    private String ispay;

    /**
     * 是否入住
     */
    @TableField("ISCHECK")
    private String ischeck;

    /**
     * 付款方式 付款类型：1.现金，2：支付宝，3微信。。
     */
    @TableField("PAY_TYPE")
    private String payType;

    /**
     * 付款金额
     */
    @TableField("PAY_AMOUNT")
    private BigDecimal payAmount;

    /**
     * 付款时间
     */
    @TableField("PAY_TIME")
    private Date payTime;

    @TableField("IS_DELETE")
    private String isDelete;


}
