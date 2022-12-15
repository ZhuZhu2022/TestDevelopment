package ceshiren.com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class TestSum extends TestCalculatorBase{
    static Stream<Arguments> sum1Test(){
        return Stream.of(
                Arguments.arguments(8,9,17),
                Arguments.arguments(1,99,100),
                Arguments.arguments(-1,-99,-100)
        );
    }

    static Stream<Arguments> sum2Test(){
        return Stream.of(
                Arguments.arguments(85,-90,13,8),
                Arguments.arguments(56,-43,-50,-37)
        );
    }

    static Stream<Arguments> sum3Test(){
        return Stream.of(
                Arguments.arguments(1,100,"请输入范围内的整数！"),
                Arguments.arguments(-100,-1,"请输入范围内的整数！")
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("两个数相加")
    public void sum1Test(int a, int b,int re){
        int result = calculator1.sum(a,b);
        assertEquals(result,re);
        logger.info("计算结果：" + result);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("三个数相加")
    public void sum2Test(int a,int b,int c, int re){
        int result = calculator1.sum(a,b,c);
        assertEquals(result,re);
        logger.info("计算结果：" + result);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("加数超出合法范围")
    public void sum3Test(int a,int b,String re){
         Exception e = assertThrowsExactly(IllegalArgumentException.class,()->calculator1.sum(a,b));
         String message = e.getMessage().toString();
         assertThat("失败断言",message,is(re));
    }

}
