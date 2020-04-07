package com.bsuc.homestay.controller;


import com.bsuc.homestay.entity.Admin;
import com.bsuc.homestay.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/getAdminById")
    public Object getAdminById(){
//        System.out.println(adminService.getById(1));
        Admin admin = new Admin ();
        admin.setAdminName("hhh");
        admin.setAdminUsername("admin");
        admin.setAdminPassword("123456");
        Admin login =adminService.login(admin);
        System.out.println("登录陈宫"+login);
        return login;
    }
//
//    @RequestMapping("/login")
//    public Admin login(){
//        Admin admin = new Admin ();
//        admin.setAdminName("hhh");
//        admin.setAdminUsername("admin");
//        admin.setAdminPassword("123456");
//        Admin login =adminService.login(admin);
//        if(login == null){
//            return login;
//        }
//        return "登录成功";
//    }

}

