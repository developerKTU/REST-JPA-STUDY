package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Category와 Item의 중간 엔티티
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne                                              // CategoryItem이 Category와 N:1 관계
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne                                              // CategoryItem이 Item과 N:1 관계
    @JoinColumn(name = "item_id")
    private Item item;
}