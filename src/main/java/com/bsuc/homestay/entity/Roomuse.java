package com.bsuc.homestay.entity;

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
 * 房间使用
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Roomuse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房间编号
     */
    @TableField("ROOM_ID")
    private Integer roomId;

    /**
     * 使用日期
     */
    @TableField("ROOMUSE_DATE")
    private Date roomuseDate;

    /**
     * 使用状态 0 入住
1 预订
3 锁定
     */
    @TableField("ROOMUSE_STATUS")
    private String roomuseStatus;

    @TableField("IS_DELETE")
    private String isDelete;

    /**
     * 乐观锁
     */
    @TableField("REVISION")
    private Integer revision;

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


}
