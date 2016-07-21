import static org.junit.Assert.*;
import org.junit.Test;

public class TestCaseTest {
    @Test
    public void testTemplateMethod() {
        TestCase test = new TestCase("TestClass.testMethod");
        TestResult result = new TestResult();
        test.run(result);
        assertEquals("setUp testMethod tearDown ", test.log);
    }
    @Test
    public void testResult() {
        TestCase test = new TestCase("TestClass.testMethod");
        TestResult result = new TestResult();
        test.run(result);
        assertEquals("1 run, 0 failed", result.summary());
    }
    @Test
    public void testFailedResult() {
        TestCase test = new TestCase("TestClass.testBrokenMethod");
        TestResult result = new TestResult();
        test.run(result);
        assertEquals("1 run, 1 failed", result.summary());
    }
    @Test
    public void testFailedResultFormatting() {
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        assertEquals("1 run, 1 failed", result.summary()); 
    }
    @Test
    public void testTestSuite() {
        TestSuite suite = new TestSuite();
        suite.add(new TestCase("TestClass.testMethod"));
        suite.add(new TestCase("TestClass.testBrokenMethod"));
        TestResult result = new TestResult();
        suite.run(result);
        assertEquals("2 run, 1 failed", result.summary());
        assertEquals("setUp testMethod tearDown setUp java.lang.Exception tearDown ", suite.log);
    }
}
