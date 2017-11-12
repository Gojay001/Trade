package xin.gojay.nmid.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.gojay.nmid.service.PersonalService;
import xin.gojay.nmid.util.ResponseUtil;

/**
 * @author Gojay
 * @date 2017/11/11.
 */
@Controller
@RequestMapping(value = "api/personal")
public class PersonalController {
    private final PersonalService personalService;

    @Autowired
    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    /**
     * 查看个人收藏
     * @param userId 用户id
     * @return 响应
     */
    @RequestMapping(value = "/showStar/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil showStar(@PathVariable Integer userId) {
        return personalService.showStar(userId);
    }

    /**
     * 查看个人预约
     * @param userId 用户id
     * @return 响应
     */
    @RequestMapping(value = "/showOrder/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil showOrder(@PathVariable Integer userId) {
        return personalService.showOrder(userId);
    }

    /**
     * 查看已购
     * @param userId 用户id
     * @return 响应
     */
    @RequestMapping(value = "/showFinish/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil showFinish(@PathVariable Integer userId) {
        return personalService.showFinish(userId);
    }

    /**
     * 查看用户发布商品信息
     * @param userId 用户id
     * @return 响应
     */
    @RequestMapping(value = "/showPublish/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil showPublish(@PathVariable Integer userId) {
        return personalService.showPublish(userId);
    }

    /**
     * 查看用户求购商品信息
     * @param userId 用户id
     * @return 响应
     */
    @RequestMapping(value = "/showAsk/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil showAsk(@PathVariable Integer userId) {
        return personalService.showAsk(userId);
    }

    /**
     * 根据用户求购信息推送相似商品
     * @param userId 用户id
     * @return 响应
     */
    @RequestMapping(value = "/showMessage/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil showMessage(@PathVariable Integer userId) {
        return personalService.showMessage(userId);
    }
}
