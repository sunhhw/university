package com.applets.university.transaction.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.applets.university.transaction.entity.WxUser;
import com.applets.university.transaction.mapper.LoginMapper;
import com.applets.university.transaction.service.ILoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shw
 * @since 2021-08-05
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, WxUser> implements ILoginService {

    @Override
    public JSON authCode2Session(String appId, String secret, String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, Object> params = new HashMap<>(2);
        params.put("appid", appId);
        params.put("secret", secret);
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");

        String result = HttpUtil.get(url, params, 2000);
        return JSONUtil.parse(result);
    }
}
