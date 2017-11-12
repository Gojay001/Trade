package xin.gojay.nmid.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
public class Goods {
    private int id;
    private String name;
    private double price;
    private String catagory;
    private String detail;
    private Date createTime;
    private Integer sellId;
    private Integer buyId;
    private int status;
    private int view;
    private List<String> image = new ArrayList<>();

    public Goods() {
    }

    public Goods(int id, String name, double price, String catagory, String detail,
                 Date createTime, Integer sellId, Integer buyId, int status, int view, List<String> image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.catagory = catagory;
        this.detail = detail;
        this.createTime = createTime;
        this.sellId = sellId;
        this.buyId = buyId;
        this.status = status;
        this.view = view;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", catagory='" + catagory + '\'' +
                ", detail='" + detail + '\'' +
                ", createTime=" + createTime +
                ", sellId=" + sellId +
                ", buyId=" + buyId +
                ", status=" + status +
                ", view=" + view +
                ", image=" + image +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSellId() {
        return sellId;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }
}
