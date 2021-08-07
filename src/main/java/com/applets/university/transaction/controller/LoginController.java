package com.applets.university.transaction.controller;


import cn.hutool.json.JSON;
import com.applets.university.common.api.AjaxResult;
import com.applets.university.transaction.entity.WxUser;
import com.applets.university.transaction.service.ILoginService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shw
 * @since 2021-08-05
 */
@RestController
@RequestMapping("/login")
@Api("登录接口")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    /**
     * appid
     */
    private final static String APP_ID = "";
    /**
     * 密钥
     */
    private final static String SECRET = "";

    /**
     * 微信小程序登录
     *
     * @param code
     * @return
     */
    @PostMapping("/{code}")
    @ApiOperation("获取用户信息")
    public AjaxResult login(@PathVariable("code") String code) {
        // 根据code获取openId,sessionKey
        JSON result = loginService.authCode2Session(APP_ID, SECRET, code);
        Integer errCode = result.getByPath("errcode", Integer.class);
        String errmsg = result.getByPath("errmsg", String.class);
        // 如果 errCode != 0 则返回错误信息
        if (errCode != 0) {
            return AjaxResult.failed(errmsg);
        }
        // 获取到相应的数据
        String openId = result.getByPath("openId", String.class);
        String sessionKey = result.getByPath("sessionKey", String.class);
        String unionId = result.getByPath("unionId", String.class);

        // 根据openId去查询数据库，如果存在则表示登录过，反正没有登录过，录入登录信息
        WxUser user = loginService.getOne(new LambdaQueryWrapper<WxUser>().eq(WxUser::getOpenId, openId));
        if (Objects.isNull(user)) {
            // 查询微信用户的基本信息并存入数据库
             //String userInfo = WeChatUtil.decryptData(authUserDto.getEncryptedData(), sessionKey, authUserDto.getIv());
        } else {

        }

        return AjaxResult.success();
}


}
