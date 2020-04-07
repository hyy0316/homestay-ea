package com.bsuc.homestay.modules.system.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bsuc.homestay.base.DataEntity;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 系统用户实体类
 * Author： yyhuang
 * Date：2020/4/6 0006
 */
@TableName("sys_user")
public class User extends DataEntity<User> {
    private static final long serialversionUID = 1L;
    /**
     * 用户名
     */
    @TableField("user_id")
    private long id;
    /**
     * 用户名
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 昵称
     */
    @TableField(value = "nick_name",strategy = FieldStrategy.IGNORED)
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * shiro加密盐
     */
    private String salt;

    /**
     * 手机号码
     */
    @TableField(strategy = FieldStrategy.IGNORED)
    private String tel;

    /**
     * 邮箱
     */
    @TableField(strategy = FieldStrategy.IGNORED)
    private String email;

    /**
     * 账号是否锁定
     */
    private Boolean locked;


    /**
     * 图标
     */
    @TableField(strategy = FieldStrategy.IGNORED)
    private String icon;
    /**
     * 角色
     */
    @TableField(exist = false)
    private Set<Role> roleLists = Sets.newHashSet();
    /**
     * 角色 - 对应的菜单
     */
    @TableField(exist = false)
    private Set<Menu> menu = Sets.newHashSet();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Set<Role> getRoleLists() {
        return roleLists;
    }

    public void setRoleLists(Set<Role> roleLists) {
        this.roleLists = roleLists;
    }

    public Set<Menu> getMenu() {
        return menu;
    }

    public void setMenu(Set<Menu> menu) {
        this.menu = menu;
    }

}
