//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.flower.entity;


import com.flower.entity.BaseEntity;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(
        name = "cartitem"
)
public class CartItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    @Column
    private int count;

    public static CartItem createCartItem(Cart cart, Item item, int count) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setItem(item);
        cartItem.setCount(count);
        return cartItem;
    }

    public void addCount(int count) {
        this.count += count;
    }

    public void updateCount(int count) {
        this.count = count;
    }

    public static CartItemBuilder builder() {
        return new CartItemBuilder();
    }

    public Long getCino() {
        return this.id;
    }

    public Cart getCart() {
        return this.cart;
    }

    public Item getItem() {
        return this.item;
    }

    public int getCount() {
        return this.count;
    }

    public void setCino(final Long id) {
        this.id = id;
    }

    public void setCart(final Cart cart) {
        this.cart = cart;
    }

    public void setItem(final Item item) {
        this.item = item;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public CartItem(final Long cino, final Cart cart, final Item item, final int count) {
        this.id = cino;
        this.cart = cart;
        this.item = item;
        this.count = count;
    }

    public CartItem() {
    }

    public static class CartItemBuilder {
        private Long id;
        private Cart cart;
        private Item item;
        private int count;

        CartItemBuilder() {
        }

        public CartItemBuilder cino(final Long id) {
            this.id = id;
            return this;
        }

        public CartItemBuilder cart(final Cart cart) {
            this.cart = cart;
            return this;
        }

        public CartItemBuilder item(final Item item) {
            this.item = item;
            return this;
        }

        public CartItemBuilder count(final int count) {
            this.count = count;
            return this;
        }

        public CartItem build() {
            return new CartItem(this.id, this.cart, this.item, this.count);
        }

        public String toString() {
            return "CartItem.CartItemBuilder(cino=" + this.id + ", cart=" + this.cart + ", item=" + this.item + ", count=" + this.count + ")";
        }
    }
}
