package xin.gojay.nmid.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.gojay.nmid.dao.GoodsDao;
import xin.gojay.nmid.dao.ImageDao;
import xin.gojay.nmid.dao.StarDao;
import xin.gojay.nmid.entity.Goods;
import xin.gojay.nmid.service.PersonalService;
import xin.gojay.nmid.util.PageUtil;
import xin.gojay.nmid.util.ResponseUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gojay
 * @date 2017/11/11.
 */
@Service
public class PersonalServiceImpl implements PersonalService {
    private static final int PAGE_SIZE = 10;
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
    public ResponseUtil showStar(Integer userId, int nowPage) {
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
        return handleList(goodsList, nowPage);
    }

    @Override
    public ResponseUtil showOrder(Integer userId, int nowPage) {
        List<Goods> goodsList = goodsDao.listOrderGoods(userId);
        return handleList(goodsList, nowPage);
    }

    @Override
    public ResponseUtil showFinish(Integer userId, int nowPage) {
        List<Goods> goodsList = goodsDao.listFinishGoods(userId);
        return handleList(goodsList, nowPage);
    }

    @Override
    public ResponseUtil showPublish(Integer userId, int nowPage) {
        List<Goods> goodsList = goodsDao.listUserPublishGoods(userId);
        return handleList(goodsList, nowPage);
    }

    @Override
    public ResponseUtil showAsk(Integer userId, int nowPage) {
        List<Goods> goodsList = goodsDao.listUserAskGoods(userId);
        return handleList(goodsList, nowPage);
    }

    @Override
    public ResponseUtil showMessage(Integer userId, int nowPage) {
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
        return handleList(responseList, nowPage);
    }

    @Override
    public ResponseUtil handleList(List<Goods> goodsList, int nowPage) {
        // 分页处理
        PageUtil<Goods> goodsPageUtil = new PageUtil<>(nowPage, PAGE_SIZE, goodsList).paging();
        if (goodsPageUtil == null || goodsPageUtil.getList() == null || goodsPageUtil.getList().size() == 0) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        // 根据goodsId获取商品图片列表
        for (Goods goods : goodsList) {
            goods.setImage(imageDao.getImage(goods.getId()));
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(goodsPageUtil);
        return responseUtil;
    }
}
