package xin.gojay.nmid.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.gojay.nmid.dao.GoodsDao;
import xin.gojay.nmid.dao.StarDao;
import xin.gojay.nmid.dao.UserDao;
import xin.gojay.nmid.entity.Goods;
import xin.gojay.nmid.entity.Star;
import xin.gojay.nmid.service.ButtonService;
import xin.gojay.nmid.util.ResponseUtil;

/**
 * @author Gojay
 * @date 2017/11/8.
 */
@Service
public class ButtonServiceImpl implements ButtonService {
    private static final int TRUE = 1;
    private static final int FALSE = 0;
    private static final int GOODS_STATUS_PUBLISH = 1;
    private static final int GOODS_STATUS_ORDER = 2;
    private static final int GOODS_STATUS_FINISH = 3;
    private ResponseUtil responseUtil;

    private final StarDao starDao;
    private final GoodsDao goodsDao;
    private final UserDao userDao;

    @Autowired
    public ButtonServiceImpl(StarDao starDao, GoodsDao goodsDao, UserDao userDao) {
        this.starDao = starDao;
        this.goodsDao = goodsDao;
        this.userDao = userDao;
    }

    @Override
    public ResponseUtil starGoods(Star star) {
        if (star.getUserId() == null) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        if (star.getGoodsId() == FALSE) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        if (starDao.starIsExist(star) != null) {
            responseUtil = new ResponseUtil(400, "info error");
            responseUtil.setBody(star);
            return responseUtil;
        }
        if (starDao.starGoods(star) != TRUE) {
            responseUtil = new ResponseUtil(500, "error");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(201, "success");
        responseUtil.setBody(star);
        return responseUtil;
    }

    @Override
    public ResponseUtil unstarGoods(Star star) {
        if (star.getUserId() == null) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        if (star.getGoodsId() == FALSE) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        if (starDao.starIsExist(star) == null) {
            responseUtil = new ResponseUtil(400, "info error");
            responseUtil.setBody(star);
            return responseUtil;
        }
        if (starDao.unstarGoods(starDao.starIsExist(star).getId()) != TRUE) {
            responseUtil = new ResponseUtil(500, "error");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(204, "success");
        return responseUtil;
    }

    @Override
    public ResponseUtil orderGoods(Integer userId, int goodsId) {
        if (userId == null || userDao.getUserById(userId) == null) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        Goods goods = goodsDao.getGoodsById(goodsId);
        if (goodsId == FALSE || goods == null) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        if (goods.getSellId() == null || goods.getBuyId() != null || goods.getStatus() != GOODS_STATUS_PUBLISH) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }

        goods.setBuyId(userId);
        goods.setStatus(GOODS_STATUS_ORDER);
        if (goodsDao.updateGoods(goods) != TRUE) {
            responseUtil = new ResponseUtil(500, "error");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(201, "success");
        responseUtil.setBody(goods);
        return responseUtil;
    }

    @Override
    public ResponseUtil cancelOrderGoods(int goodsId) {
        Goods goods = goodsDao.getGoodsById(goodsId);
        if (goodsId == FALSE || goods == null) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        if (goods.getSellId() == null || goods.getBuyId() == null || goods.getStatus() != GOODS_STATUS_ORDER) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }

        goods.setBuyId(null);
        goods.setStatus(GOODS_STATUS_PUBLISH);
        if (goodsDao.updateGoods(goods) != TRUE) {
            responseUtil = new ResponseUtil(500, "error");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(201, "success");
        responseUtil.setBody(goods);
        return responseUtil;
    }

    @Override
    public ResponseUtil finishTrade(int goodsId) {
        Goods goods = goodsDao.getGoodsById(goodsId);
        if (goodsId == FALSE || goods == null) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        if (goods.getSellId() == null || goods.getBuyId() == null || goods.getStatus() == GOODS_STATUS_FINISH) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }

        goods.setStatus(GOODS_STATUS_FINISH);
        if (goodsDao.updateGoods(goods) != TRUE) {
            responseUtil = new ResponseUtil(500, "error");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(201, "success");
        responseUtil.setBody(goods);
        return responseUtil;
    }
}
