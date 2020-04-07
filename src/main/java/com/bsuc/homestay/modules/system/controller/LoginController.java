package com.bsuc.homestay.modules.system.controller;

import com.bsuc.homestay.base.Result;
import com.bsuc.homestay.entity.Admin;
import com.bsuc.homestay.service.AdminService;
import com.google.common.collect.Maps;
import com.mysql.cj.util.StringUtils;
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
@Transactional(rollbackFor = RuntimeException.class)
@CrossOrigin
public class LoginController {
//    private static final logger LOGGER = ILoggerFactory.getLogger(LodinController.class);
    @Value("$ser.prot")
    private String port;

    @Autowired
    AdminService adminService;
    //登录 通过账号密码
    @RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"})
    public Result loginMain(Admin admin ){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        Admin admin1 = new Admin();
        if(StringUtils.isNullOrEmpty(admin.getAdminUsername()) || StringUtils.isNullOrEmpty(admin.getAdminPassword())){
            return null;
        }
        Map<String,Object> map = Maps.newHashMap();
        try {
            admin1 = adminService.login(admin);
            if(admin1 == null){
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                result.setDetail(admin1);
            }

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
