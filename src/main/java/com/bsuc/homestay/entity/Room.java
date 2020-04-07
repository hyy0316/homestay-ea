package com.bsuc.homestay.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 房间表
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房间编号
     */
    @TableId(value = "ROOM_ID", type = IdType.AUTO)
    private Integer roomId;

    /**
     * 房间名称
     */
    @TableField("ROOM_NAME")
    private String roomName;

    /**
     * 房间描述
     */
    @TableField("ROOM_DESCRIPTION")
    private String roomDescription;

    /**
     * 可住人数
     */
    @TableField("ROOM_PERSON")
    private Integer roomPerson;

    /**
     * 房间价格
     */
    @TableField("ROOM_PRICE")
    private BigDecimal roomPrice;

    /**
     * 图片
     */
    @TableField("ROOM_IMGE")
    private String roomImge;

    /**
     * 是否可用
     */
    @TableField("ROOM_STATUS")
    private String roomStatus;

    @TableField("IS_DELETE")
    private String isDelete;


}
