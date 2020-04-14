package com.bsuc.homestay.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bsuc.homestay.base.Result;
import com.bsuc.homestay.entity.Guest;
import com.bsuc.homestay.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@RestController
@CrossOrigin(origins = "*")
@Transactional(rollbackFor = RuntimeException.class)
@RequestMapping("/api/guest")
public class GuestController {
    @Value("$ser.prot")
    private String port;
    @Autowired
    GuestService guestService;


    /**
     * description: 根据id查询客户信息
     * author: YYHUANG
     * create_time: 2020/4/15 1:30
     */
    @ResponseBody
    @GetMapping(value = "/getGuestById", produces = {"application/json;charset=UTF-8"})
    public Result getGuestById(@RequestBody Map<String, Integer> map) {
        Integer guestId = map.get("id");
        Result<Guest> result = new Result<Guest>();
        System.out.println(guestId);
        result.setSuccess(false);
        result.setDetail(null);

        try {
            Guest guest = guestService.findGuestById(guestId);
            if (guest == null) {
                result.setMsg("找不到该客户信息");
            } else {
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(guest);
            }

        } catch (Exception e) {
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
    @RequestMapping(value = "/findGuestList",produces = {"application/json;charset=UTF-8"})
    public  Result<Guest> findGuestList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                        @RequestParam(value = "size",defaultValue = "10") Integer size){
        //初始化
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);


        Page<Guest> page2 = new Page<>(page, size);

        //分页查询
        guestService.page(page2,null);
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
    @PostMapping(value = "/insertGuest")
    public Result insertGuest( Guest guest){
        Result<Guest> result = new Result<Guest>();
        result.setSuccess(false);
        result.setDetail(null);
//        if (StringUtils.isNullOrEmpty(guest.getGuestPassword())){
//            result.setSuccess(false);
//            return result;
//        }

//        查询身份证号是否已存在
        if(guestService.userCount(guest.getGuestIdcard()) >= 1){
            result.setMsg("身份证号已存在");
            result.setSuccess(false);
            return result;
        }

        //查询手机号是否已存在
        if(guestService.userCount(guest.getGuestPhone()) >= 1){
            result.setMsg("手机号已绑定");
            result.setSuccess(false);
            return result;
        }


        try {
//            Guest.setGuestPassword(ToolUtil.encryptBasedDes(Guest.getGuestPassword()));
            Boolean flag = guestService.save(guest);
            if(flag){
                result.setMsg("添加成功");
                result.setSuccess(true);
                result.setDetail(guest);
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
    @PostMapping(value = "/upadataGuest")
    public Result upadataGuest(Guest guest){
        Result<Guest> result = new Result<Guest>();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Boolean flag = guestService.updateById(guest);
            if(flag){
                result.setMsg("修改成功");
                result.setSuccess(true);
                result.setDetail(guest);
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
    @RequestMapping(value = "/deletebyGuest")
    public Result deletebyGuest(@RequestParam("id") Integer GuestId) {
        Result<String> result = new Result<String>();
        result.setSuccess(false);
        result.setDetail(null);
        try {
//            boolean flag = true;
//            for (Integer GuestId : GuestIds) {
//                System.out.println(GuestId);
//            }
            Boolean flag = guestService.removeById(GuestId);
            if (flag) {
                result.setMsg("删除成功");
                result.setSuccess(true);
                result.setDetail("");
            } else {
                result.setMsg("修改失败");
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

}

