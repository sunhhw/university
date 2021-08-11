package com.applets.university.trade.mapper;

import com.applets.university.trade.entity.Trade;
import com.applets.university.trade.vo.TradeInfoVO;
import com.applets.university.trade.vo.TradeVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 二手交易-发布 Mapper 接口
 * </p>
 *
 * @author shw
 * @since 2021-08-07
 */
public interface TradeMapper extends BaseMapper<Trade> {


    /**
     * 获取交易列表数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页条数
     * @param schoolId 学校id
     * @param keyWord  关键字
     * @return
     */
    List<TradeVO> listTrade(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,
                            @Param("schoolId") Integer schoolId, @Param("keyWord") String keyWord,
                            @Param("module") String module, @Param("category") String category,
                            @Param("fineness") String fineness);

    /**
     * 商品详情
     *
     * @param id
     * @return
     */
    List<TradeInfoVO> getTradeInfo(@Param("id") Integer id, @Param("module") String module,
                                   @Param("category") String category, @Param("fineness") String fineness);
}
