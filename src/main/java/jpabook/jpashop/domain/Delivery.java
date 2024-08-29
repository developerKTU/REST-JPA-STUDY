package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;                                                // 배송 ID

    // 배송정보와 주문자 정보는 일대일 관계
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    Order order;                                                    // 배송받을 주문자 (일대일 관계)

    @Embedded
    private Address address;                                        // 배송주소

    @Enumerated(EnumType.STRING)                                    // @Enumerated : 엔티티 매핑에서 enum 타입을 사용할때 명시
    private DeliveryStatus status;                                  // 배송상태 [READY(준비), COMP(배송완료)]

    /* 연관관계 메서드 */
    public void addOrder(Order order){
        this.order = order;
    }

}
