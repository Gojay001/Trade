package xin.gojay.nmid.entity;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
public class Star {
    private int id;
    private Integer userId;
    private int goodsId;

    public Star() {
    }

    public Star(int id, Integer userId, int goodsId) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "Star{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
}
