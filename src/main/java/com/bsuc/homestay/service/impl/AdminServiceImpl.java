package com.bsuc.homestay.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    @Autowired(required = false)
    private AdminMapper adminMapper;


    @Override
    public Admin login(Admin admin){
        //TODO 注意这边有空指针异常，需要处理
        HashMap<String, Object> map = new HashMap<>();
        map.put("admin_Username", admin.getAdminUsername());
        map.put("admin_Password", admin.getAdminPassword());
        List<Admin> admin2 = adminMapper.selectByMap(map);
        if(null!=admin2 && admin2.size() !=0){
            System.out.println(admin2.get(0));
        }
        System.out.println(admin2.get(0));
        if(admin2.size()>0){
            admin2.forEach(System.out::println);
            if(null!=admin2 && admin2.size() !=0){
                System.out.println(admin2.get(0));
                return admin2.get(0);
            }

        }
        return null;

    }

    @Override
    public Admin findAdminById(Integer adminId) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        //查询id是否相等
        queryWrapper.eq("ADMIN_ID", adminId);

        Admin admins = adminMapper.selectOne(queryWrapper);
        System.out.println(admins);
        return admins;
    }

    @Override
    public Integer userCount(String param) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        //查询姓名或手机号是否相等
        queryWrapper.eq("ADMIN_USERNAME", param).or().eq("ADMIN_PHONE", param);
        int count = adminMapper.selectCount(queryWrapper);
        return count;
    }

    @Override
    public List<Admin> findAdminList() {
        return null;
    }

    @Override
    public Boolean updataAdmin(Admin admin) {
        return null;
    }

    @Override
    public Boolean insertAdmin(Admin admin) {
        return null;
    }

    @Override
    public Boolean deleteAdmin(String adminId) {
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
