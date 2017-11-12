package xin.gojay.nmid.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.gojay.nmid.entity.Star;
import xin.gojay.nmid.service.ButtonService;
import xin.gojay.nmid.util.ResponseUtil;

/**
 * @author Gojay
 * @date 2017/11/8.
 */
@Controller
@RequestMapping(value = "api/button")
public class ButtonController {
    private final ButtonService buttonService;

    @Autowired
    public ButtonController(ButtonService buttonService) {
        this.buttonService = buttonService;
    }

    /**
     * 收藏商品
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 响应
     */
    @RequestMapping(value = "/starGoods/{userId}/{goodsId}")
    @ResponseBody
    public ResponseUtil starGoods(@PathVariable("userId") Integer userId,
                                  @PathVariable("goodsId") int goodsId) {
        Star star = new Star();
        star.setUserId(userId);
        star.setGoodsId(goodsId);
        return buttonService.starGoods(star);
    }

    /**
     * 取消收藏商品
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 响应
     */
    @RequestMapping(value = "/unstarGoods/{userId}/{goodsId}")
    @ResponseBody
    public ResponseUtil unstarGoods(@PathVariable Integer userId,
                                    @PathVariable int goodsId) {
        Star star = new Star();
        star.setUserId(userId);
        star.setGoodsId(goodsId);
        return buttonService.unstarGoods(star);
    }

    /**
     * 预约商品
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 响应
     */
    @RequestMapping(value = "/orderGoods/{userId}/{goodsId}")
    @ResponseBody
    public ResponseUtil orderGoods(@PathVariable Integer userId,
                                   @PathVariable int goodsId) {
        return buttonService.orderGoods(userId, goodsId);
    }

    /**
     * 取消预约商品
     * @param goodsId 商品id
     * @return 响应
     */
    @RequestMapping(value = "/cancelOrderGoods/{goodsId}")
    @ResponseBody
    public ResponseUtil cancelOrderGoods(@PathVariable int goodsId) {
        return buttonService.cancelOrderGoods(goodsId);
    }

    /**
     * 确认交易
     * @param goodsId 商品id
     * @return 响应
     */
    @RequestMapping(value = "/finishTrade/{goodsId}")
    @ResponseBody
    public ResponseUtil finishTrade(@PathVariable int goodsId) {
        return buttonService.finishTrade(goodsId);
    }
}
