package xin.gojay.nmid.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import xin.gojay.nmid.entity.Goods;
import xin.gojay.nmid.util.ResponseUtil;

import java.util.List;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
public interface GoodsService {
    /**
     * 发布商品（含图片）
     * @param goods 商品信息
     * @param request 请求
     * @return 响应
     */
    ResponseUtil insertGoods(Goods goods, MultipartHttpServletRequest request);

    /**
     * 储存图片到本地项目路径
     * @param goodsId 商品id
     * @param request 请求
     * @return 成功标志
     */
    List<String> saveImage(int goodsId, MultipartHttpServletRequest request);

    /**
     * 新增求购商品
     * @param goods 求购商品信息
     * @return 响应状态
     */
    ResponseUtil insertGoods(Goods goods);

    /**
     * 验证商品信息格式
     * @param goods 商品实体
     * @return 成功标志
     */
    int checkGoodsInfo(Goods goods);

    /**
     * 查询求购商品列表
     * @param nowPage 当前页
     * @return 响应
     */
    ResponseUtil listAskGoods(int nowPage);

    /**
     * 查询闲置商品列表（按时间）
     * @param nowPage 当前页
     * @return 响应状态
     */
    ResponseUtil listPublishGoodsByTime(int nowPage);

    /**
     * 查询闲置商品列表（按热度）
     * @param nowPage 当前页
     * @return 响应状态
     */
    ResponseUtil listPublishGoodsByView(int nowPage);

    /**
     * 根据商品类别查询发布中商品
     * @param catagory 商品类别
     * @param nowPage 当前页
     * @return 响应
     */
    ResponseUtil listPublishGoodsByCatagory(String catagory, int nowPage);

    /**
     * 根据商品名称模糊搜索商品列表
     * @param name 商品名称
     * @param nowPage 当前页
     * @return 响应
     */
    ResponseUtil listPublishGoodsByName(String name, int nowPage);

    /**
     * 下架商品
     * @param goodsId 商品id
     * @return 响应状态
     */
    ResponseUtil deleteGoods(int goodsId);

    /**
     * 查询商品
     * @param goodsId 商品id
     * @return 响应状态
     */
    ResponseUtil getGoods(int goodsId);
}
