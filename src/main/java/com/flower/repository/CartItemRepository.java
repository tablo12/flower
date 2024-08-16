package com.flower.repository;

import com.flower.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import com.flower.dto.CartDetailDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByCartCidAndItemId(Long cartCid, Long itemId);  // 332 추가 장바구니
    // 카트 아이디와 상품 아이디를 이용해서 상품이 장바구니에 들어있는지 조회

    @Query("select new com.flower.dto.CartDetailDto(ci.id, i.itemNm, i.price, ci.count, im.imgUrl) " +
            "from CartItem ci, ItemImg im " +
            "join ci.item i " +
            "where ci.cart.id = :cartId and im.item.id = ci.item.id and im.repimgYn = 'Y' " +
            "order by ci.regTime desc")

    List<CartDetailDto> findCartDetailDtoList(@Param("cartId") Long cartId);
    // 장바구니 페이지에 전달할 리스트를 쿼리문으로 작성 343

}