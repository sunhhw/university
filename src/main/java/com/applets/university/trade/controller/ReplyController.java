package com.applets.university.trade.controller;


import com.applets.university.common.api.AjaxResult;
import com.applets.university.common.util.AuthUtil;
import com.applets.university.trade.converter.TradeConverter;
import com.applets.university.trade.dto.ReplyParamDto;
import com.applets.university.trade.entity.Reply;
import com.applets.university.trade.service.IReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 回复 前端控制器
 * </p>
 *
 * @author shw
 * @since 2021-08-11
 */
@RestController
@RequestMapping("/trade/reply")
@Api(tags = "回复")
public class ReplyController {

    @Autowired
    private IReplyService replyService;

    @PostMapping
    @ApiOperation("回复评论")
    private AjaxResult reply(@RequestBody ReplyParamDto paramDto){
        String openId = AuthUtil.getOpenId();
        Reply reply = TradeConverter.INSTANCE.toReply(paramDto, openId);
        boolean isSuccess = replyService.save(reply);
        if (isSuccess) {
            return AjaxResult.success();
        }
        return AjaxResult.failed("回复评论失败！");
    }


}
