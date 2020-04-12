package com.bsuc.homestay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bsuc.homestay.entity.Admin;

import java.util.List;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
public interface AdminService extends IService<Admin> {
    Admin login(Admin admin);

    //查询根据id
    Admin findAdminById(Integer adminId);
    //查询 根据username
    Integer userCount(String param);


    //查询list
    List<Admin> findAdminList();

    //修改
    Boolean updataAdmin(Admin admin);

    //增加
    Boolean insertAdmin(Admin admin);

    //删除
    Boolean deleteAdmin(String adminId);

}

