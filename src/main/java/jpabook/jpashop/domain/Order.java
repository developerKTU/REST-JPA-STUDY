package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue
    private Long order_id;

    // 주문과 회원은 다대일 관계
    @ManyToOne(fetch = FetchType.LAZY)                          // 지연로딩 사용
    @JoinColumn(name = "member_id")                             //
    private Member member;                                      // 주문한 회원 (다대일 관계이므로 주문한 회원은 한 명이다.)

    // 주문과 주문상품은 일대다 관계
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();     // 한 주문건수 당 주문상품은 여러개가 될 수 있음.

    // 주문과 배송정보는 일대일 관계를 원칙으로 한다.
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;                                  // 배송정보

    private LocalDateTime orderDate;                            // 주문일자

    @Enumerated(EnumType.STRING)                                // @Enumerated : 엔티티 매핑에서 enum 타입을 사용할때 명시
    private OrderStatus status;                                 // 주문상태 [ORDER, CANCEL]

    /* 연관관계 메서드 */
    // 해당 주문을 진행한 회원을 set
    public void setOrderMember(Member member){
        this.member = member;
        member.getOrders().add(this);                           // 회원 엔티티에 해당 주문건 추가
    }

    // 해당 주문의 주문상품을 add
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.addOrder(this);                           // 주문상품 엔티티에 해당 주문건 추가
    }

    // 해당 주문의 배송정보를 set
    public void setOrderDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.addOrder(this);                                // 배송정보 엔티티에 해당 주문건 추가
    }
}
