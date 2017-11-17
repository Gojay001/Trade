package xin.gojay.nmid.dao;

import org.apache.ibatis.annotations.Param;
import xin.gojay.nmid.entity.Goods;

import java.util.List;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
public interface GoodsDao {
    /**
     * 将商品信息写入数据库
     * @param goods 商品实体
     * @return 成功标志
     */
    int insertGoods(Goods goods);


    /**
     * 查询求购商品列表
     * @return 求购商品列表
     */
    List<Goods> listAskGoods();

    /**
     * 查询闲置商品列表（按时间）
     * @return 闲置商品列表
     */
    List<Goods> listPublishGoodsByTime();

    /**
     * 查询闲置商品列表（按热度）
     * @return 闲置商品列表
     */
    List<Goods> listPublishGoodsByView();

    /**
     * 根据类别查询发布中商品列表
     * @param catagory 商品类别
     * @return 查询类别的发布中商品列表
     */
    List<Goods> listPublishGoodsByCatagory(@Param("catagory") String catagory);

    /**
     * 根据商品名称模糊查询发布中商品列表
     * @param name 商品名称
     * @return 商品信息列表
     */
    List<Goods> listPublishGoodsByName(@Param("name") String name);

    /**
     * 从goods表中删除商品信息
     * @param goodId 商品id
     * @return 成功标志
     */
    int deleteGoods(int goodId);

    /**
     * 根据goodsId查询商品
     * @param goodsId 商品id
     * @return 商品实体
     */
    Goods getGoodsById(int goodsId);

    /**
     * 根据goodsId增加访问量
     * @param goodsId 商品id
     * @return 成功标志
     */
    int addGoodsView(int goodsId);

    /**
     * 更改商品信息
     * @param goods 商品实体
     * @return 成功标志
     */
    int updateGoods(Goods goods);

    /**
     * 根据用户id查询预约商品
     * @param userId 用户id
     * @return 用户预约商品列表
     */
    List<Goods> listOrderGoods(Integer userId);

    /**
     * 根据用户id查询用户已完成商品
     * @param userId 用户id
     * @return 用户已完成商品列表
     */
    List<Goods> listFinishGoods(Integer userId);

    /**
     * 根据用户id查询用户发布的商品
     * @param userId 用户id
     * @return 用户已发布商品列表
     */
    List<Goods> listUserPublishGoods(Integer userId);

    /**
     * 根据用户id查询用户求购的商品
     * @param userId 用户id
     * @return 商品列表
     */
    List<Goods> listUserAskGoods(Integer userId);

    /**
     * 根据商品种类查询所有商品列表
     * @param catagory 商品种类
     * @return 商品列表
     */
    List<Goods> listAllByCatagory(String catagory);
}
