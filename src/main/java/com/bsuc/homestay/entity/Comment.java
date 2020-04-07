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
 * 评论表 
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论编号
     */
    @TableId(value = "COMMENT_ID", type = IdType.AUTO)
    private Integer commentId;

    /**
     * 订单编号
     */
    @TableField("BOOKING_ID")
    private String bookingId;

    /**
     * 评论人编号
     */
    @TableField("COMMENT_USERID")
    private Integer commentUserid;

    /**
     * 评论人姓名
     */
    @TableField("COMMENT_USERNAME")
    private String commentUsername;

    /**
     * 父级评论编号
     */
    @TableField("COMMENT_PARENT_ID")
    private Integer commentParentId;

    /**
     * 评论内容
     */
    @TableField("COMMENT_CONTENT")
    private String commentContent;

    /**
     * 是否商家回复
     */
    @TableField("IF_MERCHANT")
    private String ifMerchant;

    @TableField("IS_DELETE")
    private String isDelete;

    /**
     * 发表时间
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
