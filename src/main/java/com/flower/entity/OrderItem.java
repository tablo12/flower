//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.flower.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long oino;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "pno"
    )
    private Item item;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "ono"
    )
    private Order order;
    @Column(
            nullable = false,
            length = 20
    )
    private int oiprice;
    @Column(
            nullable = false
    )
    private int oiquantity;

    public OrderItem() {
    }

    public static OrderItem createOrderItem(Item item, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOiquantity(count);
        orderItem.setOiprice(item.getPrice());
        item.removeStock(count);
        return orderItem;
    }

    public int getTotalPrice() {
        return this.oiprice * this.oiquantity;
    }

    public void cancel() {
        this.getItem().addStock(this.oiquantity);
    }

    public Long getOino() {
        return this.oino;
    }

    public Item getItem() {
        return this.item;
    }

    public Order getOrder() {
        return this.order;
    }

    public int getOiprice() {
        return this.oiprice;
    }

    public int getOiquantity() {
        return this.oiquantity;
    }

    public void setOino(final Long oino) {
        this.oino = oino;
    }

    public void setItem(final Item item) {
        this.item = item;
    }

    public void setOrder(final Order order) {
        this.order = order;
    }

    public void setOiprice(final int oiprice) {
        this.oiprice = oiprice;
    }

    public void setOiquantity(final int oiquantity) {
        this.oiquantity = oiquantity;
    }
}
