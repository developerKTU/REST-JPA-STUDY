package jpabook.jpashop.TestClass;

import jpabook.jpashop.TestClass.Entity.TestMember;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberTestRepositoryTest {

    private final TestMemberRepository testMemberRepository;

    @Autowired
    public MemberTestRepositoryTest(TestMemberRepository testMemberRepository){
        this.testMemberRepository = testMemberRepository;
    }

    @Test
    public void saveTest() throws Exception{
        // given
        TestMember testMember = TestMember.builder()
                .username("KTU")
                .build();

        // when
        Long saveId = testMemberRepository.save(testMember);
        TestMember testMember1 = testMemberRepository.find(saveId);

        // then
        Assertions.assertThat(testMember1.getID()).isEqualTo(testMember.getID());
        Assertions.assertThat(testMember1.getUsername()).isEqualTo(testMember.getUsername());
    }
}