package com.bsuc.homestay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bsuc.homestay.entity.Booking;
import com.bsuc.homestay.mapper.BookingMapper;
import com.bsuc.homestay.service.BookingService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预订表 服务实现类
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Service
public class BookingServiceImpl extends ServiceImpl<BookingMapper, Booking> implements BookingService {

}
