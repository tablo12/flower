//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.flower.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CartItemDto {
    private @NotNull(
            message = "상품아이디는 필수 입력값입니다."
    ) Long itemId;
    private @Min(
            value = 1L,
            message = "최소 1개 이상 담아주세요"
    ) int count;

    public CartItemDto() {
    }

    public @NotNull(
            message = "상품아이디는 필수 입력값입니다."
    ) Long getItemId() {
        return this.itemId;
    }

    public int getCount() {
        return this.count;
    }

    public void setItemId(final @NotNull(
            message = "상품아이디는 필수 입력값입니다."
    ) Long itemId) {
        this.itemId = itemId;
    }

    public void setCount(final int count) {
        this.count = count;
    }
}
