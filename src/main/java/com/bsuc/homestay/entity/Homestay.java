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
 * 民宿信息表
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Homestay implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 民宿名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 民宿负责人
     */
    @TableField("PRINCIPAL")
    private String principal;

    /**
     * 联系方式
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 民宿地址
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * 民宿介绍
     */
    @TableField("Description")
    private String Description;

    /**
     * 评价表单id
     */
    @TableField("COMMEN_ID")
    private String commenId;

    /**
     * 是否有wifi
     */
    @TableField("hasWifi")
    private String hasWifi;

    /**
     * 可否停车
     */
    @TableField("hasParking")
    private String hasParking;

    /**
     * 可否寄存行李
     */
    @TableField("hasPackage")
    private String hasPackage;

    /**
     * 开业时间
     */
    @TableField("startTime")
    private Date startTime;

    /**
     * 装修时间
     */
    @TableField("decorateTime")
    private Date decorateTime;

    /**
     * 民宿图片1
     */
    private String image1;

    /**
     * 民宿图片2
     */
    private String image2;

    /**
     * 民宿图片3
     */
    private String image3;

    /**
     * 状态
     */
    private String untitled7;

    @TableField("IS_DELETE")
    private String isDelete;


}
