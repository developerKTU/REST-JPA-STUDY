package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("M")                                // 하위 클래스 (현재 클래스)에 선언. 엔티티 저장 시 부모 클래스인 Item에 M이 저장됨
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Movie extends Item{

    private String director;
    private String actor;

}
