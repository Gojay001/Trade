package xin.gojay.nmid.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.gojay.nmid.dao.GoodsDao;
import xin.gojay.nmid.dao.ImageDao;
import xin.gojay.nmid.dao.StarDao;
import xin.gojay.nmid.entity.Goods;
import xin.gojay.nmid.service.PersonalService;
import xin.gojay.nmid.util.ResponseUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gojay
 * @date 2017/11/11.
 */
@Service
public class PersonalServiceImpl implements PersonalService {
    private ResponseUtil responseUtil = null;

    private final StarDao starDao;
    private final GoodsDao goodsDao;
    private final ImageDao imageDao;

    @Autowired
    public PersonalServiceImpl(StarDao starDao, GoodsDao goodsDao, ImageDao imageDao) {
        this.starDao = starDao;
        this.goodsDao = goodsDao;
        this.imageDao = imageDao;
    }

    @Override
    public ResponseUtil showStar(Integer userId) {
        List<Integer> goodsIdList = starDao.getGoodsId(userId);
        if (goodsIdList == null) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        List<Goods> goodsList = new ArrayList<>();
        for (int goodsId : goodsIdList) {
            Goods goods = goodsDao.getGoodsById(goodsId);
            goodsList.add(goods);
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(goodsList);
        return responseUtil;
    }

    @Override
    public ResponseUtil showOrder(Integer userId) {
        List<Goods> goodsList = goodsDao.listOrderGoods(userId);
        if (goodsList == null) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        for (Goods goods : goodsList) {
            goods.setImage(imageDao.getImage(goods.getId()));
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(goodsList);
        return responseUtil;
    }

    @Override
    public ResponseUtil showFinish(Integer userId) {
        List<Goods> goodsList = goodsDao.listFinishGoods(userId);
        if (goodsList == null) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        for (Goods goods : goodsList) {
            goods.setImage(imageDao.getImage(goods.getId()));
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(goodsList);
        return responseUtil;
    }

    @Override
    public ResponseUtil showPublish(Integer userId) {
        List<Goods> goodsList = goodsDao.listUserPublishGoods(userId);
        if (goodsList == null) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        for (Goods goods : goodsList) {
            goods.setImage(imageDao.getImage(goods.getId()));
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(goodsList);
        return responseUtil;
    }

    @Override
    public ResponseUtil showAsk(Integer userId) {
        List<Goods> goodsList = goodsDao.listUserAskGoods(userId);
        if (goodsList == null) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        for (Goods goods : goodsList) {
            goods.setImage(imageDao.getImage(goods.getId()));
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(goodsList);
        return responseUtil;
    }

    @Override
    public ResponseUtil showMessage(Integer userId) {
        List<Goods> responseList = new ArrayList<>();
        List<Goods> goodsList = goodsDao.listUserAskGoods(userId);
        if (goodsList.size() == 0) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        for (Goods goods : goodsList) {
            responseList.addAll(goodsDao.listAllByCatagory(goods.getCatagory()));
        }
        if (responseList.size() == 0) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(responseList);
        return responseUtil;
    }
}
