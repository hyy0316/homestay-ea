package com.bsuc.homestay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bsuc.homestay.entity.Guest;

import java.util.List;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
public interface GuestService extends IService<Guest> {
    Guest login(Guest Guest);

    //查询根据id
    Guest findGuestById(Integer GuestId);
    //查询 根据username
    Integer userCount(String param);


    //查询list
    List<Guest> findGuestList();

    //修改
    Boolean updataGuest(Guest Guest);

    //增加
    Boolean insertGuest(Guest Guest);

    //删除
    Boolean deleteGuest(String GuestId);
}
