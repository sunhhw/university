package com.applets.university.trade.controller;


import com.applets.university.common.api.AjaxResult;
import com.applets.university.common.util.AuthUtil;
import com.applets.university.trade.converter.TradeConverter;
import com.applets.university.trade.dto.CommentParamDto;
import com.applets.university.trade.entity.Comment;
import com.applets.university.trade.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author shw
 * @since 2021-08-11
 */
@RestController
@RequestMapping("/trade/comment")
@Api(tags = "评论")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping
    @ApiOperation("发表评论")
    private AjaxResult release(@RequestBody CommentParamDto param) {
        String openId = AuthUtil.getOpenId();
        Comment comment = TradeConverter.INSTANCE.toComment(param,openId);
        boolean isSuccess = commentService.save(comment);
        if (isSuccess){
            return AjaxResult.success();
        }
        return AjaxResult.failed("发表评论失败！");
    }


}
