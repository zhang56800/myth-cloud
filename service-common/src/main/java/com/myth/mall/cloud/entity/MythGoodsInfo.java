package com.myth.mall.cloud.entity;

// 简单对象实体类
public class MythGoodsInfo {

    private int goodsId;

    private String goodsName;

    private int stock;

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsId() {
        return this.goodsId;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return this.stock;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(" goodsName=").append(goodsName);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", stock=").append(stock);
        sb.append("]");
        return sb.toString();
    }
}
