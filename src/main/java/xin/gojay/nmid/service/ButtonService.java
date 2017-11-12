package xin.gojay.nmid.service;

import xin.gojay.nmid.entity.Star;
import xin.gojay.nmid.util.ResponseUtil;

/**
 * @author Gojay
 * @date 2017/11/8.
 */
public interface ButtonService {
    /**
     * 收藏商品
     * @param star 收藏信息
     * @return 响应状态
     */
    ResponseUtil starGoods(Star star);

    /**
     * 取消收藏商品
     * @param star 收藏信息
     * @return 响应状态
     */
    ResponseUtil unstarGoods(Star star);

    /**
     * 预约商品
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 响应状态
     */
    ResponseUtil orderGoods(Integer userId, int goodsId);

    /**
     * 取消预约商品
     * @param goodsId 商品id
     * @return 响应状态
     */
    ResponseUtil cancelOrderGoods(int goodsId);

    /**
     * 确认完成交易
     * @param goodsId 商品id
     * @return 响应状态
     */
    ResponseUtil finishTrade(int goodsId);
}
