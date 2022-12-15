package ceshiren.com;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * 1.创建新型计算器
 * 2.生成测试用例ID
 * 3.log打印“开始进行计算......”
 * 4.业务逻辑测试
 * 5.log打印计算结果
 * 6.断言测试结果
 * 7.销毁测试用例ID
 * 8.关闭/退出app
 */

public class TestCalculator {
    static final Logger logger = getLogger(lookup().lookupClass());
    static Calculator calculator1;

    @BeforeAll
    static void getCalculator(){
        calculator1 = new Calculator("Calculator1");
    }


    @BeforeEach
    public void getInitId() {
        calculator1.initId();
        logger.info("开始计算......");
    }

    @Test
    public void sum1Test(){
        int result = calculator1.sum(9,8);
        assertEquals(result,17);
        logger.info("计算结果：" + result);
    }

    @Test
    public void sum2Test(){
        int result = calculator1.sum(0,1,99);
        assertEquals(result,100);
        logger.info("计算结果：" + result);
    }

    @Test
    public void sum3Test(){
        int result = calculator1.sum(-1,-99);
        assertEquals(result,-100);
        logger.info("计算结果：" + result);
    }

    @Test
    public void sum4Test(){
        int result = calculator1.sum(99,-99);
        assertEquals(result,0);
        logger.info("计算结果：" + result);
    }

    @Test
    public void sum5Test(){
        int result = calculator1.sum(85,-90,13);
        assertEquals(result,8);
        logger.info("计算结果：" + result);
    }

    @Test
    public void sum6Test(){
        int result = calculator1.sum(56,-43,-50);
        assertEquals(result,-37);
        logger.info("计算结果：" + result);
    }

    @Test
    public void sum7Test(){
        int sum7 = calculator1.sum(56,-100);
        //Assertions.fail("请输入范围内的整数！");
    }

    @Test
    public void sum8Test(){
        int sum8 = calculator1.sum(1,100);
        //Assertions.fail("请输入范围内的整数！");
    }

    @AfterEach
    public void afterDestroy(){
        //logger.info("计算结果：Result");
        calculator1.destroyId();
    }

   @AfterAll
   static void teardown(){
        logger.info("Afterall------------");
        calculator1.close();
    }

}
