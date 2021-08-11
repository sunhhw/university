package com.applets.university.trade.service.impl;

import com.applets.university.trade.entity.Comment;
import com.applets.university.trade.mapper.CommentMapper;
import com.applets.university.trade.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author shw
 * @since 2021-08-11
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
