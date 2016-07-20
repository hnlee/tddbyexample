import static org.junit.Assert.*;
import org.junit.Test;

public class TestCaseTest {
    @Test
    public void testTemplateMethod() {
        TestCase test = new TestCase("TestClass.testMethod");
        test.run();
        assertEquals("setUp testMethod tearDown ", test.log);
    }
    @Test
    public void testResult() {
        TestCase test = new TestCase("TestClass.testMethod");
        TestResult result = test.run();
        assertEquals("1 run, 0 failed", result.summary());
    }
    @Test
    public void testFailedResult() {
        TestCase test = new TestCase("TestClass.testBrokenMethod");
        TestResult result = test.run();
        assertEquals("1 run, 1 failed", result.summary());
    }
    @Test
    public void testFailedResultFormatting() {
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        assertEquals("1 run, 1 failed", result.summary()); 
    }
}
