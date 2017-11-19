package xin.gojay.nmid.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import xin.gojay.nmid.dao.GoodsDao;
import xin.gojay.nmid.dao.ImageDao;
import xin.gojay.nmid.dao.StarDao;
import xin.gojay.nmid.entity.Goods;
import xin.gojay.nmid.entity.Image;
import xin.gojay.nmid.service.GoodsService;
import xin.gojay.nmid.util.ImageUtil;
import xin.gojay.nmid.util.PageUtil;
import xin.gojay.nmid.util.ResponseUtil;
import xin.gojay.nmid.util.SearchUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    private static final int PAGE_SIZE = 10;
    private static final int NAME_LENGTH = 22;
    private static final int FALSE = 0;
    private static final int TRUE = 1;
    private ResponseUtil responseUtil = null;

    private final GoodsDao goodsDao;
    private final ImageDao imageDao;
    private final StarDao starDao;

    @Autowired
    public GoodsServiceImpl(GoodsDao goodsDao, ImageDao imageDao, StarDao starDao) {
        this.goodsDao = goodsDao;
        this.imageDao = imageDao;
        this.starDao = starDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseUtil insertGoods(Goods goods, MultipartHttpServletRequest request) {
        if (checkGoodsInfo(goods) != TRUE) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        // 保存商品信息
        if (goodsDao.insertGoods(goods) != TRUE) {
            responseUtil = new ResponseUtil(500, "error");
            return responseUtil;
        }
        // 保存图片
        List<String> imageList = saveImage(goods.getId(), request);
        if (imageList == null) {
            responseUtil = new ResponseUtil(400, "error");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(201, "success");
        goods.setImage(imageList);
        responseUtil.setBody(goods);
        return responseUtil;
    }

    @Override
    public List<String> saveImage(int goodsId, MultipartHttpServletRequest request) {
        List<String> names = new ArrayList<>();
        List<MultipartFile> files = request.getFiles("file");
        if (files.isEmpty()) {
            return null;
        }
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            // 储存图片到本地项目路径
            String name = ImageUtil.saveImage(file, request);
            System.out.println(name);
            if (name == null) {
                continue;
            }
            // 储存图片名称到数据库
            Image image = new Image();
            image.setGoodsId(goodsId);
            image.setName(name);
            imageDao.saveImage(image);
            names.add(name);
        }
        if (names.size() == FALSE) {
            return null;
        }
        return names;
    }

    @Override
    public ResponseUtil insertGoods(Goods goods) {
        if (checkGoodsInfo(goods) != TRUE) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        if (goodsDao.insertGoods(goods) != TRUE) {
            responseUtil = new ResponseUtil(500, "error");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(201, "success");
        responseUtil.setBody(goods);
        return responseUtil;
    }

    @Override
    public int checkGoodsInfo(Goods goods) {
        if (goods.getName() == null || goods.getName().length() > NAME_LENGTH) {
            return FALSE;
        }
        if (goods.getCatagory() == null) {
            return FALSE;
        }
        if (goods.getDetail() == null) {
            return FALSE;
        }
        return TRUE;
    }

    @Override
    public ResponseUtil listAskGoods(int nowPage) {
        List<Goods> goodsList = goodsDao.listAskGoods();
        return handleList(goodsList, nowPage);
    }

    @Override
    public ResponseUtil listPublishGoodsByTime(int nowPage) {
        List<Goods> goodsList = goodsDao.listPublishGoodsByTime();
        return handleList(goodsList, nowPage);
    }

    @Override
    public ResponseUtil listPublishGoodsByView(int nowPage) {
        List<Goods> goodsList = goodsDao.listPublishGoodsByView();
        return handleList(goodsList, nowPage);
    }

    @Override
    public ResponseUtil listPublishGoodsByCatagory(String catagory, int nowPage) {
        List<Goods> goodsList = goodsDao.listPublishGoodsByCatagory(catagory);
        return handleList(goodsList, nowPage);
    }

    @Override
    public ResponseUtil listPublishGoodsByName(String name, int nowPage) {
        if (name == null || "".equals(name)) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        name = SearchUtil.changeString(name);
        List<Goods> goodsList = goodsDao.listPublishGoodsByName(name);
        return handleList(goodsList, nowPage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseUtil deleteGoods(int goodsId, HttpServletRequest request) {
        if (goodsId == FALSE) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        if (goodsDao.getGoodsById(goodsId) == null) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        // 删除商品图片、收藏信息
        ImageUtil.deleteImage(goodsDao.getGoodsById(goodsId).getName(), request);
        imageDao.deleteImage(goodsId);
        starDao.deleteStar(goodsId);
        if (goodsDao.deleteGoods(goodsId) != TRUE) {
            responseUtil = new ResponseUtil(500, "error");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(204, "success");
        return responseUtil;
    }

    @Override
    public ResponseUtil getGoods(int goodsId) {
        if (goodsId == FALSE) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        Goods goods = goodsDao.getGoodsById(goodsId);
        if (goods == null) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        // 获取商品图片
        goods.setImage(imageDao.getImage(goods.getId()));
        // 增加商品浏览量
        goodsDao.addGoodsView(goodsId);
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(goods);
        return responseUtil;
    }

    @Override
    public ResponseUtil handleList(List<Goods> goodsList, int nowPage) {
        // 分页处理
        PageUtil<Goods> goodsPageUtil = new PageUtil<>(nowPage, PAGE_SIZE, goodsList).paging();
        if (goodsPageUtil == null || goodsPageUtil.getList() == null || goodsPageUtil.getList().size() == FALSE) {
            responseUtil = new ResponseUtil(200, "null");
            return responseUtil;
        }
        // 获取商品图片
        for (Goods goods : goodsPageUtil.getList()) {
            goods.setImage(imageDao.getImage(goods.getId()));
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(goodsPageUtil);
        return responseUtil;
    }
}
