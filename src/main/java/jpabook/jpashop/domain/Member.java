package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;                                    // 회원 ID

    private String name;                                // 성명

    @Embedded                                           // 주소정보를 객체(Address)로 묶기위해 사용, @Embedded : 값 타입을 '사용 하는 곳'에 명시
    private Address address;                            // 회원의 주소

    // 회원과 주문은 일대다 관계
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();     // 해당 회원이 주문한 건들
}
