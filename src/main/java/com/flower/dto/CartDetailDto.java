//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.flower.dto;


public class CartDetailDto {
    private Long cartItemId;
    private String itemNm;
    private int price;
    private int count;
    private String imgUrl;

    public CartDetailDto(Long cartItemId, String itemNm, int price, int count, String imgUrl) {
        this.cartItemId = cartItemId;
        this.itemNm = itemNm;
        this.price = price;
        this.count = count;
        this.imgUrl = imgUrl;
    }

    public Long getCartItemId() {
        return this.cartItemId;
    }

    public String getItemNm() {
        return this.itemNm;
    }

    public int getPrice() {
        return this.price;
    }

    public int getCount() {
        return this.count;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setCartItemId(final Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public void setItemNm(final String itemNm) {
        this.itemNm = itemNm;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public void setImgUrl(final String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String toString() {
        Long var10000 = this.getCartItemId();
        return "CartDetailDto(cartItemId=" + var10000 + ", itemNm=" + this.getItemNm() + ", price=" + this.getPrice() + ", count=" + this.getCount() + ", imgUrl=" + this.getImgUrl() + ")";
    }
}
