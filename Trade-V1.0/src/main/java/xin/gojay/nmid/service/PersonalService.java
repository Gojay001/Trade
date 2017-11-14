package xin.gojay.nmid.service;

import xin.gojay.nmid.entity.Goods;
import xin.gojay.nmid.util.ResponseUtil;

import java.util.List;

/**
 * @author Gojay
 * @date 2017/11/11.
 */
public interface PersonalService {
    /**
     * 查看个人收藏
     * @param userId 用户id
     * @return 响应状态
     */
    ResponseUtil showStar(Integer userId);

    /**
     * 查看个人预约
     * @param userId 用户id
     * @return 响应状态
     */
    ResponseUtil showOrder(Integer userId);

    /**
     * 查看个人已完成
     * @param userId 用户id
     * @return 响应状态
     */
    ResponseUtil showFinish(Integer userId);

    /**
     * 查看用户发布的商品
     * @param userId 用户id
     * @return 响应状态
     */
    ResponseUtil showPublish(Integer userId);

    /**
     * 查看用户求购的商品
     * @param userId 用户id
     * @return 响应状态
     */
    ResponseUtil showAsk(Integer userId);

    /**
     * 查看用户消息
     * @param userId 用户id
     * @return 响应状态
     */
    ResponseUtil showMessage(Integer userId);

    /**
     * 处理商品列表返回信息
     * @param goodsList 商品列表
     * @return 响应状态
     */
    ResponseUtil handleList(List<Goods> goodsList);
}
