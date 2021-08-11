package com.applets.university.trade.service.impl;

import com.applets.university.common.constant.DictConstant;
import com.applets.university.common.constant.ModuleConstant;
import com.applets.university.trade.dto.TradeParamDto;
import com.applets.university.trade.entity.Trade;
import com.applets.university.trade.mapper.TradeMapper;
import com.applets.university.trade.service.ITradeService;
import com.applets.university.trade.vo.TradeInfoVO;
import com.applets.university.trade.vo.TradeVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 二手交易-发布 服务实现类
 * </p>
 *
 * @author shw
 * @since 2021-08-07
 */
@Service
public class TradeServiceImpl extends ServiceImpl<TradeMapper, Trade> implements ITradeService {

    @Autowired
    private TradeMapper tradeMapper;

    @Override
    public List<TradeVO> listTrade(TradeParamDto param) {
        Integer pageNum = param.getPageNum();
        Integer pageSize = param.getPageSize();
        pageNum = (pageNum - 1) * pageSize;
        Integer schoolId = param.getSchoolId();
        String keyWord = param.getKeyWord();
        String module = ModuleConstant.TRADE;
        String category = DictConstant.CATEGORY;
        String fineness = DictConstant.FINENESS;

        return tradeMapper.listTrade(pageNum, pageSize, schoolId, keyWord, module, category, fineness);
    }

    @Override
    public List<TradeInfoVO> getTradeInfo(Integer id) {
        String module = ModuleConstant.TRADE;
        String category = DictConstant.CATEGORY;
        String fineness = DictConstant.FINENESS;
        return tradeMapper.getTradeInfo(id, module, category, fineness);
    }
}
