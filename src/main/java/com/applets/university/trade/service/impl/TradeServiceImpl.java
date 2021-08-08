package com.applets.university.trade.service.impl;

import com.applets.university.trade.entity.Trade;
import com.applets.university.trade.mapper.TransactionMapper;
import com.applets.university.trade.service.ITradeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 二手交易-发布 服务实现类
 * </p>
 *
 * @author shw
 * @since 2021-08-07
 */
@Service
public class TradeServiceImpl extends ServiceImpl<TransactionMapper, Trade> implements ITradeService {

}
