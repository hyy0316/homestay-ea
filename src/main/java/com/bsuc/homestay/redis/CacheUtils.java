//package com.bsuc.homestay.redis;
//
//import com.bsuc.homestay.base.MySysUser;
//import com.bsuc.homestay.modules.system.entity.User;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Caching;
//
///**
// * Author： yyhuang
// * Date：2020/4/6 0006
// */
//public class CacheUtils {
//    /**
//     * 清楚当当前用户redis缓存
//     */
//
//    @Caching(evict = {
//        @CacheEvict(value = "user",key = "'user_id_' + T(String).valueOf(#result.id)",condition = "#result.id != null and #result.id != 0"),
//            @CacheEvict(value = "user",key = "'user_name_' + #result.loginName",condition = "#result.loginName != null and #result.loginName != 0"),
//            @CacheEvict(value = "user",key = "'user_tel_' + #result.tel",condition = "#result.tel != null and #result.tel != 0"),
//    })
//    public User clearUserCache() {
//        User user = new User();
//        user.setId(MySysUser.id());
//        return user.selectById();
//    }
//}
