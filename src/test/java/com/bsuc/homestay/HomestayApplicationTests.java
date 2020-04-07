package com.bsuc.homestay;

import com.bsuc.homestay.entity.Admin;
import com.bsuc.homestay.mapper.AdminMapper;
import com.bsuc.homestay.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HomestayApplication.class})
class HomestayApplicationTests {

    private Object AdminService;
    private AdminMapper adminMapper;
    @Test
    void contextLoads() {
        AdminService adminService = null;
        System.out.println(adminService.getById(1));

    }

    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("admin_Username", "admin");
        map.put("admin_Password", 123456);
        List<Admin> admin = adminMapper.selectByMap(map);
        admin.forEach(System.out::println);
    }

}
