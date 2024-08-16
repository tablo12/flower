//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.flower.entity;

import com.flower.constant.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(
        name = "orders"
)
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long ono;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "mno"
    )
    private Member member;
    private LocalDateTime odate;
    @Enumerated(EnumType.STRING)
    private OrderStatus ostatus;
    private int totalPrice;
    @OneToMany(
            mappedBy = "order",
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<OrderItem> orderItems = new ArrayList();

    public Order() {
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public static Order createOrder(Member member, List<OrderItem> orderItemList) {
        Order order = new Order();
        order.setMember(member);
        Iterator var3 = orderItemList.iterator();

        while(var3.hasNext()) {
            OrderItem orderItem = (OrderItem)var3.next();
            order.addOrderItem(orderItem);
        }

        order.setOstatus(OrderStatus.ORDER);
        order.setOdate(LocalDateTime.now());
        return order;
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        OrderItem orderItem;
        for(Iterator var2 = this.orderItems.iterator(); var2.hasNext(); totalPrice += orderItem.getTotalPrice()) {
            orderItem = (OrderItem)var2.next();
        }

        return totalPrice;
    }

    public void cancelOrder() {
        OrderStatus var10001 = this.ostatus;
        this.ostatus = OrderStatus.CANCEL;
        Iterator var1 = this.orderItems.iterator();

        while(var1.hasNext()) {
            OrderItem orderItem = (OrderItem)var1.next();
            orderItem.cancel();
        }

    }

    public Long getOno() {
        return this.ono;
    }

    public Member getMember() {
        return this.member;
    }

    public LocalDateTime getOdate() {
        return this.odate;
    }

    public OrderStatus getOstatus() {
        return this.ostatus;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOno(final Long ono) {
        this.ono = ono;
    }

    public void setMember(final Member member) {
        this.member = member;
    }

    public void setOdate(final LocalDateTime odate) {
        this.odate = odate;
    }

    public void setOstatus(final OrderStatus ostatus) {
        this.ostatus = ostatus;
    }

    public void setTotalPrice(final int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderItems(final List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
