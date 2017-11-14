package xin.gojay.nmid.dao;

import xin.gojay.nmid.entity.Goods;
import xin.gojay.nmid.entity.Image;

import java.util.List;

/**
 * @author Gojay
 * @date 2017/11/9.
 */
public interface ImageDao {
    /**
     * 将商品图片名称储存到image表
     * @param image 图片信息
     * @return 成功标志
     */
    int saveImage(Image image);

    /**
     * 根据商品id查询商品图片名称列表
     * @param goodsId 商品id
     * @return 商品图片名称列表
     */
    List<String> getImage(int goodsId);

    /**
     * 根据商品id删除商品图片名称
     * @param goodsId 商品id
     * @return 成功标志
     */
    int deleteImage(int goodsId);
}
