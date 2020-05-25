package wangyang.demo;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wangyang.controller.IndexController;

@SpringBootTest(classes = IndexController.class)
class DemoApplicationTests {

    @Autowired
    private IndexController indexController;
    @Test
    void contextLoads() {
        TestCase.assertEquals("1",this.indexController.test()+"");
    }

}
