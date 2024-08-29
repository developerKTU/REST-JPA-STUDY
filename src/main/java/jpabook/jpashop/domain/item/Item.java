package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.domain.CategoryItem;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   // 객체 상속관계 정의 (DB에선 슈퍼/서브 타입 정의)
@DiscriminatorColumn                                    // 하위 클래스를 구분하는 용도 (Default : DTYPE)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    // 실무에서는 @ManyToMany 사용 금지! @ManyToOne, @OneToMany로 풀어서 사용하기
    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categories = new ArrayList<>();

}
