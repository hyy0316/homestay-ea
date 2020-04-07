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
 * 入住表
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RoomCheckin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 入住单编号
     */
    @TableId(value = "CHRCKIN_ID", type = IdType.AUTO)
    private Integer chrckinId;

    /**
     * 订单编号
     */
    @TableField("BOOKING_ID")
    private Integer bookingId;

    /**
     * 房间编号
     */
    @TableField("ROOM_ID")
    private Integer roomId;

    /**
     * 入住时间
     */
    @TableField("CHRCKIN_TIME")
    private Date chrckinTime;

    /**
     * 离店时间
     */
    @TableField("CHRCKOUT_TIME")
    private Date chrckoutTime;

    /**
     * 订单总额
     */
    @TableField("COMSUMPTION")
    private BigDecimal comsumption;

    /**
     * 已收金额
     */
    @TableField("AMOUNT_RECEIVED")
    private BigDecimal amountReceived;

    /**
     * 状态
     */
    @TableField("STATUS")
    private String status;

    @TableField("IS_DELETE")
    private String isDelete;


}
