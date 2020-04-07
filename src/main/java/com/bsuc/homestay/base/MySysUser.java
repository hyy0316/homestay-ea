//package com.bsuc.homestay.base;
//
//import org.apache.shiro.SecurityUtils;
//
///**
// * 用户信息
// * Author： yyhuang
// * Date：2020/4/6 0006
// */
//public class MySysUser {
//
//    public static String icon(){
//        return ShiroUser().getIcon();
//    }
//    public static Long id(){
//        return ShiroUser().id();
//    }
//    public static String loginName(){
//        return ShiroUser().getLoginName();
//    }
//    public static String nickName(){
//        return ShiroUser().getNickName();
//    }
//    public static ShiroUser ShiroUser(){
//        ShiroUser user = (AuthRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
//        return ShiroUser().getNickName();
//    }
//}
