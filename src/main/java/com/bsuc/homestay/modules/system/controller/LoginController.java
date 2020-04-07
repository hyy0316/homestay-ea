package com.bsuc.homestay.modules.system.controller;

import com.bsuc.homestay.entity.Admin;
import com.bsuc.homestay.service.AdminService;
import com.google.common.collect.Maps;
import com.mysql.cj.util.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 * CrossOrigin  支持跨越
 * Author： yyhuang
 * Date：2020/4/7 0007
 */
@RestController
@RequestMapping("/api")
@Transactional
@CrossOrigin
public class LoginController {
//    private static final logger LOGGER = ILoggerFactory.getLogger(LodinController.class);
    @Value("$ser.prot")
    private String port;

    @Autowired
    AdminService adminService;
    //登录 通过账号密码
    @RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"})
    public String loginMain(Admin admin ){
        if(StringUtils.isNullOrEmpty(admin.getAdminUsername()) || StringUtils.isNullOrEmpty(admin.getAdminPassword())){
            return "用户名和密码不能为空";
        }
        Map<String,Object> map = Maps.newHashMap();
        try {
            Admin admin1 = adminService.login(admin);
            if(admin == null){
                return "用户名或密码错误";
            }

        }catch (IncorrectCredentialsException e){
            e.getMessage();
            e.printStackTrace();
        }
        return "登录成功";
    }
}
