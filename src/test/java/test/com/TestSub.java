package test.com;

import ceshiren.com.TestCalculatorBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSub extends TestCalculatorBase {

    static Stream<Arguments> subTest(){
        return Stream.of(
                Arguments.arguments(9,8,1),
                Arguments.arguments(1,99,-98),
                Arguments.arguments(-1,-99,98),
                Arguments.arguments(99,-99,198),
                Arguments.arguments(100,1,0),
                Arguments.arguments(0,-100,0),
                Arguments.arguments(99,0,99),
                Arguments.arguments(-99,0,-99)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("两个整数相减")
    public void subTest(int a,int b,int re){
        int result = calculator1.subtract(a,b);
        assertEquals(result,re);
        logger.info("计算结果：" + result);
    }
}
