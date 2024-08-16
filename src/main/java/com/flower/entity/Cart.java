//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.flower.entity;

import com.flower.entity.Member;
import jakarta.persistence.*;

@Entity
@Table(
        name = "cart"
)
public class Cart extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long cid;
    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "mno"
    )
    private Member member;

    public static Cart createCart(Member member) {
        Cart cart = new Cart();
        cart.setMember(member);
        return cart;
    }

    public static CartBuilder builder() {
        return new CartBuilder();
    }

    public Long getCid() {
        return this.cid;
    }

    public Member getMember() {
        return this.member;
    }

    public void setCid(final Long cid) {
        this.cid = cid;
    }

    public void setMember(final Member member) {
        this.member = member;
    }

    public Cart(final Long cid, final Member member) {
        this.cid = cid;
        this.member = member;
    }

    public Cart() {
    }

    public String toString() {
        Long var10000 = this.getCid();
        return "Cart(cid=" + var10000 + ", member=" + this.getMember() + ")";
    }

    public static class CartBuilder {
        private Long cid;
        private Member member;

        CartBuilder() {
        }

        public CartBuilder cid(final Long cid) {
            this.cid = cid;
            return this;
        }

        public CartBuilder member(final Member member) {
            this.member = member;
            return this;
        }

        public Cart build() {
            return new Cart(this.cid, this.member);
        }

        public String toString() {
            return "Cart.CartBuilder(cid=" + this.cid + ", member=" + this.member + ")";
        }
    }
}
