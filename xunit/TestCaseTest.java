import static org.junit.Assert.*;
import org.junit.Test;

public class TestCaseTest {
    @Test
    public void testWasRun() {
        WasRun test = new WasRun("testClass.testMethod");
        assertEquals("Not run", test.wasRun);
        test.run();
        assertEquals("Passed", test.wasRun);
    }
}
