//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.flower.dto;

import java.util.List;

public class CartOrderDto {
    private Long cartItemId;
    private List<CartOrderDto> cartOrderDtoList;

    public CartOrderDto() {
    }

    public Long getCartItemId() {
        return this.cartItemId;
    }

    public List<CartOrderDto> getCartOrderDtoList() {
        return this.cartOrderDtoList;
    }

    public void setCartItemId(final Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public void setCartOrderDtoList(final List<CartOrderDto> cartOrderDtoList) {
        this.cartOrderDtoList = cartOrderDtoList;
    }

    public String toString() {
        Long var10000 = this.getCartItemId();
        return "CartOrderDto(cartItemId=" + var10000 + ", cartOrderDtoList=" + this.getCartOrderDtoList() + ")";
    }
}
