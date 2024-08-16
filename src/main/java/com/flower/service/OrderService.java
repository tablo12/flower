package com.flower.service;

import com.flower.dto.OrderDto;
import com.flower.entity.*;
import com.flower.repository.ItemRepository;
import com.flower.repository.MemberRepository;
import com.flower.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.flower.dto.OrderHistDto;
import com.flower.dto.OrderItemDto;
import com.flower.repository.ItemImgRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.thymeleaf.util.StringUtils;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final ItemRepository itemRepository;  // 아이템 리포지토리 CRUD

    private final MemberRepository memberRepository;  // 회원 리포지토리 CRUD

    private final OrderRepository orderRepository;  // 주문 리포지토리 CRUD

    private final ItemImgRepository itemImgRepository;  // 아이템이미지 리포지토리 CRUD

    public Long order(OrderDto orderDto, String memail){
        // 주문자의 이메일과 오더를 받아 아이템을 찾음.
        Item item = itemRepository.findById(orderDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);

        Member member = memberRepository.findByMemail(memail);

        List<OrderItem> orderItemList = new ArrayList<>();  // 주문자의 주문이 다수임으로 리스트로 처리함.
        OrderItem orderItem = OrderItem.createOrderItem(item, orderDto.getCount());
        orderItemList.add(orderItem);
        Order order = Order.createOrder(member, orderItemList);
        orderRepository.save(order);

        return order.getOno();
    }

    @Transactional(readOnly = true)  // 313 추가 (OrderControll에서 호출 됨)
    public Page<OrderHistDto> getOrderList(String memail, Pageable pageable) {

        List<Order> orders = orderRepository.findOrders(memail, pageable);
        Long totalCount = orderRepository.countOrder(memail);

        List<OrderHistDto> orderHistDtos = new ArrayList<>();

        for (Order order : orders) {
            OrderHistDto orderHistDto = new OrderHistDto(order);
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem orderItem : orderItems) {
                ItemImg itemImg = itemImgRepository.findByItemIdAndRepimgYn
                        (orderItem.getItem().getId(), "Y");
                OrderItemDto orderItemDto =
                        new OrderItemDto(orderItem, itemImg.getImgUrl());
                orderHistDto.addOrderItemDto(orderItemDto);
            }

            orderHistDtos.add(orderHistDto);
        }

        return new PageImpl<OrderHistDto>(orderHistDtos, pageable, totalCount);
    }

    @Transactional(readOnly = true)  // 324 추가
    public boolean validateOrder(Long orderId, String memail){  // 현재 로그인 사용자와 주문 데이터를 생성한 사용자가 같은지 검사
        Member curMember = memberRepository.findByMemail(memail);
        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        Member savedMember = order.getMember();

        if(!StringUtils.equals(curMember.getMemail(), savedMember.getMemail())){
            return false;
        }

        return true;
    }

    public void cancelOrder(Long orderId){  // 주문 취소용 메서드
        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        order.cancelOrder();
    }

    public Long orders(List<OrderDto> orderDtoList, String memail){
        // 361 추가
        Member member = memberRepository.findByMemail(memail);
        List<OrderItem> orderItemList = new ArrayList<>();

        for (OrderDto orderDto : orderDtoList) {
            Item item = itemRepository.findById(orderDto.getItemId())
                    .orElseThrow(EntityNotFoundException::new);

            OrderItem orderItem = OrderItem.createOrderItem(item, orderDto.getCount());
            orderItemList.add(orderItem);
        }

        Order order = Order.createOrder(member, orderItemList);
        orderRepository.save(order);

        return order.getOno();
    }

}