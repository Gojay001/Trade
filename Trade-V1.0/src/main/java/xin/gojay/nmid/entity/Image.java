package xin.gojay.nmid.entity;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
public class Image {
    private int id;
    private int goodsId;
    private String name;

    public Image() {
    }

    public Image(int id, int goodsId, String name) {
        this.id = id;
        this.goodsId = goodsId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
