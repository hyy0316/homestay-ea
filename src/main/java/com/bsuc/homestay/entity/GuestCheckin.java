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
 * 客户入住详情
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GuestCheckin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 入住单编号
     */
    @TableField("CHRCKIN_ID")
    private Integer chrckinId;

    /**
     * 客户编号
     */
    @TableField("GUEST_ID")
    private Integer guestId;

    /**
     * 创建时间
     */
    @TableField("CREATED_TIME")
    private Date createdTime;

    @TableField("IS_DELETE")
    private String isDelete;


}
