package com.applets.university.trade.service;

import cn.hutool.json.JSON;
import com.applets.university.trade.entity.WxUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shw
 * @since 2021-08-05
 */
public interface ILoginService extends IService<WxUser> {

    /**
     * 获取openId和sessionKey
     * @param appId
     * @param secret
     * @param code
     * @return
     */
    JSON authCode2Session(String appId, String secret, String code);

}
