package ceshiren.com;

import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
/*
@SelectClasses({
        ceshiren.com.TestSum.class,
        ceshiren.com.TestParallel.class,
        concatStr.com.TestConcatStr.class,
        test.com.TestSub.class
})
 */
@SelectPackages({
        "ceshiren.com"

})
@IncludePackages("ceshiren.com")
public class TestCalculatorSuite {

}
