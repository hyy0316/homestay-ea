package com.bsuc.homestay.entity;

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
 * 预订表
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @TableId(value = "BOOKING_ID", type = IdType.AUTO)
    private Integer bookingId;

    /**
     * 客户编号
     */
    @TableField("GUEST_ID")
    private Integer guestId;

    /**
     * 房间编号
     */
    @TableField("ROOM_ID")
    private Integer roomId;

    /**
     * 入住日期
     */
    @TableField("CHECKIN_DATE")
    private Date checkinDate;

    /**
     * 离店日期
     */
    @TableField("CHECKOUT_DATE")
    private Date checkoutDate;

    /**
     * 预定时间
     */
    @TableField("BOOKING_TIME")
    private Date bookingTime;

    /**
     * 订单状态 0待支付，表订单已生成，但用户未支付//
1已付款，表明订单已经支付
2已完成 ，表明订单已进行入住，在生成入住表的同时，因为入住的同时肯定先要完成支付，所有不存在支付和完成冲突，完成即已支付，修改为
3已取消，表明该订未入住。
     */
    @TableField("BOOKING_STATUS")
    private String bookingStatus;

    /**
     * 备注
     */
    @TableField("BOOKING_NOTE")
    private String bookingNote;

    /**
     * 是否已评论
     */
    @TableField("IF_COMMENT")
    private String ifComment;

    @TableField("IS_DELETE")
    private String isDelete;


}
