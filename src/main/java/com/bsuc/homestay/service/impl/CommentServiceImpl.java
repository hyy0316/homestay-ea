package com.bsuc.homestay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bsuc.homestay.entity.Comment;
import com.bsuc.homestay.mapper.CommentMapper;
import com.bsuc.homestay.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表  服务实现类
 * </p>
 *
 * @author yyhuang
 * @since 2020-04-06
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
