package com.applets.university.trade.service;

import com.applets.university.trade.dto.TradeParamDto;
import com.applets.university.trade.entity.Trade;
import com.applets.university.trade.vo.TradeInfoVO;
import com.applets.university.trade.vo.TradeVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 二手交易-发布 服务类
 * </p>
 *
 * @author shw
 * @since 2021-08-07
 */
public interface ITradeService extends IService<Trade> {

    /**
     * 获取商品列表数据
     * @param param
     * @return
     */
    List<TradeVO> listTrade(TradeParamDto param);

    /**
     * 获取商品详情
     * @param id
     * @return
     */
    List<TradeInfoVO> getTradeInfo(Integer id);
}
