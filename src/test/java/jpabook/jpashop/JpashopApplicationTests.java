package jpabook.jpashop;

import jpabook.jpashop.TestClass.LombokTestClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpashopApplicationTests {

    @Test
    void contextLoads() {

        // Lombok Test
        LombokTestClass lombokTestClass = new LombokTestClass();
        lombokTestClass.setData("Lombok Test!");
        String data = lombokTestClass.getData();

        System.out.println(data);
    }
}