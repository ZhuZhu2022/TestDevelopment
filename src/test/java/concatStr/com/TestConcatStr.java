package concatStr.com;

import ceshiren.com.TestCalculatorBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConcatStr extends TestCalculatorBase {

    static Stream<Arguments> strConcatTest(){
        return Stream.of(
                Arguments.arguments("hello","world","hello world"),
                Arguments.arguments("hello","","hello "),
                Arguments.arguments("","world"," world")
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("两个字符串连接")
    public void strConcatTest(String str1,String str2,String re){
        String resultStr= calculator1.concatStr(str1,str2);
        assertEquals(resultStr,re);
        logger.info(str1+"拼接"+str2+"结果："+resultStr);
    }
}
