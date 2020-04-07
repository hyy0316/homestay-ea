package com.bsuc.homestay.service;

import com.bsuc.homestay.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
