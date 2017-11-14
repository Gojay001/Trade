package xin.gojay.nmid.web;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import xin.gojay.nmid.entity.Goods;
import xin.gojay.nmid.service.GoodsService;
import xin.gojay.nmid.util.ResponseUtil;

import java.sql.Date;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
@Controller
@RequestMapping("api/goods")
public class GoodsController {
    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    /**
     * 发布闲置商品
     * @param userId 用户id
     * @param name 商品名称
     * @param price 商品价格
     * @param catagory 商品类别
     * @param detail 商品说明
     * @param request 文件请求
     * @return 响应
     */
    @RequestMapping(value = "/publishGoods", method = RequestMethod.POST)
    @ResponseBody
    public ResponseUtil publishGoods(@Param("userId") Integer userId,
                                     @Param("name") String name,
                                     @Param("price") double price,
                                     @Param("catagory") String catagory,
                                     @Param("detail") String detail,
                                     MultipartHttpServletRequest request) {
        Goods goods = new Goods();
        goods.setName(name);
        goods.setPrice(price);
        goods.setCatagory(catagory);
        goods.setDetail(detail);
        goods.setCreateTime(new Date(System.currentTimeMillis()));
        goods.setSellId(userId);
        goods.setStatus(1);
        goods.setView(0);
        return goodsService.insertGoods(goods, request);
    }

    /**
     * 发布求购商品
     * @param userId 用户id
     * @param name 商品名称
     * @param price 商品价格
     * @param catagory 商品种类
     * @param detail 商品说明
     * @return 状态
     */
    @RequestMapping(value = "/askGoods", method = RequestMethod.POST)
    @ResponseBody
    public ResponseUtil askGoods(@Param("userId") int userId,
                                 @Param("name") String name,
                                 @Param("price") double price,
                                 @Param("catagory") String catagory,
                                 @Param("detail") String detail) {
        Goods goods = new Goods();
        goods.setName(name);
        goods.setPrice(price);
        goods.setCatagory(catagory);
        goods.setDetail(detail);
        goods.setCreateTime(new Date(System.currentTimeMillis()));
        goods.setBuyId(userId);
        goods.setStatus(1);
        goods.setView(0);
        return goodsService.insertGoods(goods);
    }

    /**
     * 求购商品列表
     * @param nowPage 当前页
     * @return 响应
     */
    @RequestMapping(value = "/listAskGoods/{nowPage}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil listAskGoods(@PathVariable int nowPage) {
        return goodsService.listAskGoods(nowPage);
    }

    /**
     * 闲置商品列表（按时间顺序）
     * @param nowPage 当前页
     * @return 响应
     */
    @RequestMapping(value = "/listPublishGoodsByTime/{nowPage}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil listPublishGoodsByTime(@PathVariable int nowPage) {
        return goodsService.listPublishGoodsByTime(nowPage);
    }

    /**
     * 闲置商品列表（按热度顺序）
     * @param nowPage 当前页
     * @return 响应
     */
    @RequestMapping(value = "/listPublishGoodsByView/{nowPage}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil listPublishGoodsByView(@PathVariable int nowPage) {
        return goodsService.listPublishGoodsByView(nowPage);
    }

    /**
     * 闲置商品列表（按类别）
     * @param catagory 类别名称
     * @param nowPage 当前页
     * @return 响应
     */
    @RequestMapping(value = "/listPublishGoodsByCatagory/{catagory}/{nowPage}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil listPublishGoodsByCatagory(@PathVariable String catagory,
                                                   @PathVariable int nowPage) {
        return goodsService.listPublishGoodsByCatagory(catagory, nowPage);
    }

    /**
     * 闲置商品列表（模糊搜索）
     * @param name 商品名称
     * @param nowPage 当前页
     * @return 响应
     */
    @RequestMapping(value = "/listPublishGoodsByName/{name}/{nowPage}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil listPublishGoodsByName(@PathVariable String name,
                                               @PathVariable int nowPage) {
        return goodsService.listPublishGoodsByName(name, nowPage);
    }

    /**
     * 下架商品
     * @param goodsId 商品id
     * @return 响应
     */
    @RequestMapping(value = "/deleteGoods/{goodsId}")
    @ResponseBody
    public ResponseUtil deleteGoods(@PathVariable int goodsId) {
        return goodsService.deleteGoods(goodsId);
    }

    /**
     * 查看商品
     * @param goodsId 商品id
     * @return 响应
     */
    @RequestMapping(value = "/getGoods/{goodsId}")
    @ResponseBody
    public ResponseUtil getGoods(@PathVariable int goodsId) {
        return goodsService.getGoods(goodsId);
    }
}
