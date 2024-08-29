package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("B")                                // 하위 클래스 (현재 클래스)에 선언. 엔티티 저장 시 부모 클래스인 Item에 B가 저장됨
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Book extends Item{

    private String author;
    private String isbn;

}
