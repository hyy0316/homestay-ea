package com.bsuc.homestay.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bsuc.homestay.entity.Admin;
import com.bsuc.homestay.mapper.AdminMapper;
import com.bsuc.homestay.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin login(Admin admin){

        //TODO 注意这边有空指针异常，需要处理
        HashMap<String, Object> map = new HashMap<>();
        map.put("admin_Username", admin.getAdminUsername());
        map.put("admin_Password", admin.getAdminPassword());
        List<Admin> admin2 = adminMapper.selectByMap(map);
        System.out.println(admin2.get(0));
        if(admin2.size()>0){
            admin2.forEach(System.out::println);
            return admin2.get(0);
        }
        return null;

    }

    @Override
    public boolean saveBatch(Collection<Admin> entityList) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Admin> entityList) {
        return false;
    }

    @Override
    public Admin getOne(Wrapper<Admin> queryWrapper) {
        return null;
    }
}
