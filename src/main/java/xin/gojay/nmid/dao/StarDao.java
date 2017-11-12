package xin.gojay.nmid.dao;

import xin.gojay.nmid.entity.Star;

import java.util.List;

/**
 * @author Gojay
 * @date 2017/11/8.
 */
public interface StarDao {
    /**
     * 将收藏信息写入收藏表
     * @param star 收藏信息
     * @return 成功标志
     */
    int starGoods(Star star);

    /**
     * 验证收藏信息是否已经存在
     * @param star 收藏信息
     * @return 收藏实体
     */
    Star starIsExist(Star star);

    /**
     * 将收藏信息删除
     * @param id 收藏信息id
     * @return 成功标志
     */
    int unstarGoods(int id);

    /**
     * 根据商品id删除商品收藏
     * @param goodsId 商品id
     * @return 成功标志
     */
    int deleteStar(int goodsId);

    /**
     * 根据userId查询收藏的goodsId集合
     * @param userId 用户id
     * @return goodsId集合
     */
    List<Integer> getGoodsId(Integer userId);
}
