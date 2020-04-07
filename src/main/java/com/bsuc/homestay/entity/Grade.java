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
 * 等级
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 等级编号
     */
    @TableField("GRADE_ID")
    private Integer gradeId;

    /**
     * 等级名称
     */
    @TableField("GRADE_NAME")
    private String gradeName;

    /**
     * 优惠折扣
     */
    @TableField("DISCOUNT")
    private BigDecimal discount;

    @TableField("IS_DELETE")
    private String isDelete;

    /**
     * 创建时间
     */
    @TableField("CREATED_TIME")
    private Date createdTime;

    /**
     * 更新时间
     */
    @TableField("UPDATED_TIME")
    private Date updatedTime;


}
