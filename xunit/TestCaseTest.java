import static org.junit.Assert.*;
import org.junit.Test;

public class TestCaseTest {
    @Test
    public void testTemplateMethod() {
        TestCase test = new TestCase("TestClass.testMethod");
        test.run();
        assertEquals("setUp testMethod tearDown ", test.log);
    }
}
