import static org.junit.Assert.*;
import org.junit.Test;

public class TestCaseTest {
    @Test
    public void testWasRun() {
        TestCase test = new TestCase("TestClass.testMethod");
        assertEquals(null, test.wasRun);
        test.run();
        assertTrue(test.wasRun);
    }
    
    @Test
    public void testSetUp() {
        TestCase test = new TestCase("TestClass.testMethod");
        test.run();
        assertTrue(test.wasSetUp);
    }
}
