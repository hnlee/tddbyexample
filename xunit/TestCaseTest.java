import static org.junit.Assert.*;
import org.junit.Test;

public class TestCaseTest {
    @Test
    public void testWasRun() {
        WasRun test = new WasRun("testMethod");
        assertEquals("Not run", test.wasRun);
        test.testMethod();
        assertEquals("Passed", test.wasRun);
    }
}
