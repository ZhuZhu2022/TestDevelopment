package ceshiren.com;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class TestCalculatorBase {
    public static final Logger logger = getLogger(lookup().lookupClass());
    public static Calculator calculator1;

    @BeforeAll
    public static void getCalculator(){
        calculator1 = new Calculator("Calculator1");
        logger.info("创建新型计算器实例");
    }


    @BeforeEach
    public void getInitId() {
        calculator1.initId();
        logger.info("开始计算......");
    }

    @AfterEach
    public void afterDestroy(){
        //logger.info("计算结果：Result");
        calculator1.destroyId();
    }

    @AfterAll
    public static void teardown(){
        logger.info("退出新型计算器");
        calculator1.close();
    }

}
