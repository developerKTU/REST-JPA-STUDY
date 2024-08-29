package jpabook.jpashop.TestClass;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jpabook.jpashop.TestClass.Entity.TestMember;
import org.springframework.stereotype.Repository;

@Repository
public class TestMemberRepository {

    @PersistenceContext
    private EntityManager em;

    //CREATE
    public Long save(TestMember testMember){
        em.persist(testMember);
        return testMember.getID();
    }

    // READ
    public TestMember find(Long id){
        return em.find(TestMember.class, id);
    }
}
