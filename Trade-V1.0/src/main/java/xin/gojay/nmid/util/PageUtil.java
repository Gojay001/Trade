package xin.gojay.nmid.util;

import xin.gojay.nmid.entity.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gojay
 * @date 2017/11/17
 */
public class PageUtil<T> {
    private List<T> list;
    private int nowPage;
    private int pageSize;
    private int totalRecord;
    private int totalPage;

    public PageUtil(int nowPage, int pageSize, List<T> list) {
        this.nowPage = nowPage;
        this.pageSize = pageSize;
        this.list = list;
    }

    private boolean checkPage(int nowPage, int totalPage) {
        return  !(nowPage < 1 || nowPage > totalPage);

    }

    public PageUtil<T> paging() {
        totalRecord = list.size();
        totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
        if (!checkPage(nowPage, totalPage)) {
            return null;
        }
        // 判断是否为最后一页
        if (nowPage != totalPage) {
            this.list = list.subList((nowPage-1)*pageSize, (nowPage-1)*pageSize + pageSize);
        } else {
            this.list = list.subList((nowPage-1)*pageSize, totalRecord);
        }
        return this;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "list=" + list +
                ", nowPage=" + nowPage +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                '}';
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /// 测试代码
    /*public static void main(String[] args) {
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods());
        goodsList.add(new Goods());
        goodsList.add(new Goods());
        goodsList.add(new Goods());
        goodsList.add(new Goods());
        System.out.println(goodsList);
        System.out.println("-----------------------------------");
        PageUtil<Goods> goodsPageUtil = new PageUtil<Goods>(4, 2, goodsList).paging();
        if (goodsPageUtil != null) {
            System.out.println(goodsPageUtil.getList().size());
            System.out.println(goodsPageUtil);
        }
    }*/
}
