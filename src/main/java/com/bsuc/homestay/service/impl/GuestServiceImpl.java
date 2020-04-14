package com.bsuc.homestay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bsuc.homestay.entity.Guest;
import com.bsuc.homestay.mapper.GuestMapper;
import com.bsuc.homestay.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Service
public class GuestServiceImpl extends ServiceImpl<GuestMapper, Guest> implements GuestService {
    @Autowired(required = false)
    private GuestMapper guestMapper;
    @Override
    public Guest login(Guest guest) {
        //TODO 注意这边有空指针异常，需要处理
        HashMap<String, Object> map = new HashMap<>();
        map.put("GUEST_PHONE", guest.getGuestPhone());
        map.put("GUEST_PASSWORD", guest.getGuestPassword());

        List<Guest> guest2 = guestMapper.selectByMap(map);
        if(null!=guest2 && guest2.size() !=0){
            System.out.println(guest2.get(0));
        }
        System.out.println(guest2.get(0));
        if(guest2.size()>0){
            guest2.forEach(System.out::println);
            if(null!=guest2 && guest2.size() !=0){
                System.out.println(guest2.get(0));
                return guest2.get(0);
            }

        }
        return null;
    }

    @Override
    public Guest findGuestById(Integer GuestId) {
        QueryWrapper<Guest> queryWrapper = new QueryWrapper<>();
        //查询id是否相等
        queryWrapper.eq("GUEST_ID", GuestId);

        Guest guests = guestMapper.selectOne(queryWrapper);
        System.out.println(guests);
        return guests;
    }

    @Override
    public Integer userCount(String param) {
        QueryWrapper<Guest> queryWrapper = new QueryWrapper<>();
        //查询身份证号或手机号是否相等
        queryWrapper.eq("GUEST_PHONE", param).or().eq("GUEST_IDCARD", param);
        int count = guestMapper.selectCount(queryWrapper);
        return count;
    }

    @Override
    public List<Guest> findGuestList() {
        return null;
    }

    @Override
    public Boolean updataGuest(Guest Guest) {
        return null;
    }

    @Override
    public Boolean insertGuest(Guest Guest) {
        return null;
    }

    @Override
    public Boolean deleteGuest(String GuestId) {
        return null;
    }

}
