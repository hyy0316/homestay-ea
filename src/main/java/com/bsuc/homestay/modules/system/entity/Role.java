//package com.bsuc.homestay.modules.system.entity;
//
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableName;
//import com.bsuc.homestay.base.DataEntity;
//
//import java.util.Set;
//
///**
// * 角色实体类
// * Author： yyhuang
// * Date：2020/4/6 0006
// */
//@TableName("sys_role")
//public class Role extends DataEntity<Role> {
//    private static final long serialversionUID = 1L;
//
//    /**
//     * 角色名称
//     */
//    private String name;
//
//    @TableField(exist = false)
//    private Set<Menu> menuSet;
//
//    @TableField(exist = false)
//    private Set<User> userSet;
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<Menu> getMenuSet() {
//        return menuSet;
//    }
//
//    public void setMenuSet(Set<Menu> menuSet) {
//        this.menuSet = menuSet;
//    }
//
//    public Set<User> getUserSet() {
//        return userSet;
//    }
//
//    public void setUserSet(Set<User> userSet) {
//        this.userSet = userSet;
//    }
//}
