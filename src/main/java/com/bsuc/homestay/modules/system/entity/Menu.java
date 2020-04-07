package com.bsuc.homestay.modules.system.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.bsuc.homestay.base.TreeEntity;
import org.hibernate.validator.constraints.Length;

/**
 * 菜单实体类
 * Author： yyhuang
 * Date：2020/4/6 0006
 */
public class Menu extends TreeEntity<Menu> {
    private static final long serialversionUID = 1L;

    private String name;

    private String icon;

    /**
     * 连接地址
     */
    @TableField(strategy = FieldStrategy.IGNORED)
    private String href;

    /**
     * 打开方式
     */
    @TableField(strategy = FieldStrategy.IGNORED)
    private String target;

    /**
     * 打开方式
     */
    @TableField(value = "is_show",strategy = FieldStrategy.IGNORED)
    private Boolean isShow;

    /**
     * 类型（0表示菜单，1表示按钮，-1表示目录）
     *
     */
    @TableField(value = "is_menu",strategy = FieldStrategy.IGNORED)
    private Boolean isMenu;

    /**
     * 菜单背景颜色
     */
    @TableField(value = "bg_color",strategy = FieldStrategy.IGNORED)
    private String bgColor;

    /**
     * 菜单背景颜色
     */
    @TableField(strategy = FieldStrategy.IGNORED)
    private String permission;

    /**
     * 菜单值
     */
    @TableField(exist = false)
    protected Integer dataCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 0 , max = 1000, message = "icon长度必须结余1和1000之间")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Boolean getShow() {
        return isShow;
    }

    public void setShow(Boolean show) {
        isShow = show;
    }

    public Boolean getMenu() {
        return isMenu;
    }

    public void setMenu(Boolean menu) {
        isMenu = menu;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }
}
