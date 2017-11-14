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
        // 根据userId获取收藏goodsId列表
        List<Integer> goodsIdList = starDao.getGoodsId(userId);
        if (goodsIdList == null) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        // 根据goodsId列表获取商品列表
        List<Goods> goodsList = new ArrayList<>();
        for (int goodsId : goodsIdList) {
            Goods goods = goodsDao.getGoodsById(goodsId);
            goodsList.add(goods);
        }
        // 根据goodsId获取商品图片列表
        for (Goods goods : goodsList) {
            goods.setImage(imageDao.getImage(goods.getId()));
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(goodsList);
        return responseUtil;
    }

    @Override
    public ResponseUtil showOrder(Integer userId) {
        List<Goods> goodsList = goodsDao.listOrderGoods(userId);
        return handleList(goodsList);
    }

    @Override
    public ResponseUtil showFinish(Integer userId) {
        List<Goods> goodsList = goodsDao.listFinishGoods(userId);
        return handleList(goodsList);
    }

    @Override
    public ResponseUtil showPublish(Integer userId) {
        List<Goods> goodsList = goodsDao.listUserPublishGoods(userId);
        return handleList(goodsList);
    }

    @Override
    public ResponseUtil showAsk(Integer userId) {
        List<Goods> goodsList = goodsDao.listUserAskGoods(userId);
        return handleList(goodsList);
    }

    @Override
    public ResponseUtil showMessage(Integer userId) {
        List<Goods> responseList = new ArrayList<>();
        // 根据userId获取用户求购商品列表
        List<Goods> goodsList = goodsDao.listUserAskGoods(userId);
        // 没有求购则返回
        if (goodsList.size() == 0) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        // 根据求购商品按类别查询闲置商品列表
        for (Goods goods : goodsList) {
            responseList.addAll(goodsDao.listAllByCatagory(goods.getCatagory()));
        }
        // 没有匹配的闲置商品则返回
        if (responseList.size() == 0) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(responseList);
        return responseUtil;
    }

    @Override
    public ResponseUtil handleList(List<Goods> goodsList) {
        // 商品列表为空返回
        if (goodsList == null) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        // 获取商品图片
        for (Goods goods : goodsList) {
            goods.setImage(imageDao.getImage(goods.getId()));
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(goodsList);
        return responseUtil;
    }
}
