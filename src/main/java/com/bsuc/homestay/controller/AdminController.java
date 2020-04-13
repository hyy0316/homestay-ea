package com.bsuc.homestay.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bsuc.homestay.base.Result;
import com.bsuc.homestay.entity.Admin;
import com.bsuc.homestay.service.AdminService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@RestController
@CrossOrigin(origins = "*")
@Transactional(rollbackFor = RuntimeException.class)
@RequestMapping("/api/admin")
public class AdminController {

    @Value("$ser.prot")
    private String port;
    @Autowired
    AdminService adminService;


    /**
     * 根据id 查询管理员信息
     * 使用ResponseBody返回Json格式数据
     */
    @ResponseBody
    @GetMapping(value = "/getAdminById/{adminId}",produces = {"application/json;charset=UTF-8"})
    public Result getAdminById(@PathVariable("adminId") Integer adminId){
        Result<Admin> result = new Result<Admin>();
        System.out.println(adminId);
        result.setSuccess(false);
        result.setDetail(null);

        try {
            Admin admin1 = adminService.findAdminById(adminId);
            if(admin1 == null){
                result.setMsg("找不到该用户信息");
            }else{
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(admin1);
            }

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询所有返回为一个List
     * @param page
     * @param size
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findAdminList",produces = {"application/json;charset=UTF-8"})
    public  Result<Admin> findAdminList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                    @RequestParam(value = "size",defaultValue = "10") Integer size){
        //初始化
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);

        Page<Admin> page2 = new Page<>(page, size);

        //分页查询
        adminService.page(page2,null);
        result.setDetail(page2.getRecords());
        result.setCount((int) page2.getTotal());
        result.setSuccess(true);

        System.out.println("当前页码:" + page2.getCurrent());
        System.out.println("总页数:" + page2.getPages());
        System.out.println("每页的记录数:" + page2.getSize());
        System.out.println("总记录数:" + page2.getTotal());

        System.out.println("结果:");
        page2.getRecords().forEach(System.out::println);
        return result;
    }



    /**
     * 添加管理员
     * 使用ResponseBody返回Json格式数据
     */
    @PostMapping(value = "/insertAdmin")
    public Result insertAdmin( Admin admin){
        Result<Admin> result = new Result<Admin>();
        result.setSuccess(false);
        result.setDetail(null);
        if (StringUtils.isNullOrEmpty(admin.getAdminPassword())){
            result.setSuccess(false);
            return result;
        }

        //查询用户名是否已存在
        if(adminService.userCount(admin.getAdminUsername()) == 1){
            result.setMsg("用户名已存在");
            result.setSuccess(false);
        }

        //查询手机号是否已存在
        if(adminService.userCount(admin.getAdminPhone()) == 1){
            result.setMsg("手机号已绑定");
            result.setSuccess(false);
        }


        try {
//            admin.setAdminPassword(ToolUtil.encryptBasedDes(admin.getAdminPassword()));
            Boolean flag = adminService.save(admin);
            if(flag){
                result.setMsg("添加成功");
                result.setSuccess(true);
                result.setDetail(admin);
            }else{
                result.setMsg("添加失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 修改管理员
     * 使用ResponseBody返回Json格式数据
     */
    @ResponseBody
    @PostMapping(value = "/upadataAdmin",produces = {"application/json;charset=UTF-8"})
    public Result upadataAdmin(Admin admin){
        Result<Admin> result = new Result<Admin>();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Boolean flag = adminService.updateById(admin);
            if(flag){
                result.setMsg("修改成功");
                result.setSuccess(true);
                result.setDetail(admin);
            }else{
                result.setMsg("修改失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除管理员  （将使用的是逻辑删除，只是修改状态）
     * 使用ResponseBody返回Json格式数据
     */
    @ResponseBody
    @GetMapping(value = "/deletebyAdmin",produces = {"application/json;charset=UTF-8"})
    public Result deletebyAdmin(String adminId){
        Result<String> result = new Result<String>();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Boolean flag = adminService.removeById(adminId);
            if(flag){
                result.setMsg("删除成功");
                result.setSuccess(true);
                result.setDetail("");
            }else{
                result.setMsg("修改失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}

