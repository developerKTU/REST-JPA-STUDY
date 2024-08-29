package jpabook.jpashop.TestClass.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestMember {

    @Id @GeneratedValue
    private Long ID;
    private String username;

    @Builder
    public TestMember(String username){
        this.username = username;
    }

}
