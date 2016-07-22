import java.lang.reflect.*;
import java.util.ArrayList;

// Just some feedback
class TestCase {
    // Data members of a java class should be marked private by default, like so:
    private String className;
    private String methodName;
    private String log;
    
    TestCase(String name) {
        String[] classMethodName = name.split("\\.");
        this.className = classMethodName[0];
        this.methodName = classMethodName[1];
    }
    // You should have whitespace between the methods
    
    void run(TestResult result) {
        result.testStarted();
        setUp();
        try {
            testMethod();
        } catch (Exception e) {
            result.testFailed();
            log = log + e.getCause() + " ";
        }
        tearDown();
    }
    
    void setUp() {
        log = "setUp ";
    }
    
    void testMethod() throws Exception {
        try {
            Class<?> cls = Class.forName(className);
            Method method = cls.getDeclaredMethod(methodName);
            Object obj = cls.newInstance();
            method.invoke(obj);
            log = log + "testMethod ";
        } catch (Exception e) {
            throw e; 
        }
    } 
    
    void tearDown() {
        log = log + "tearDown "; 
    }
}

// In general each of these should be a seperate file
class TestResult {
    int runCount;
    int errorCount;
    TestResult() {
        runCount = 0;
        errorCount = 0;
    }
    void testStarted() {
        runCount++;
    }
    void testFailed() {
        errorCount++;
    }
    String summary() {
        return String.format("%1$d run, %2$d failed", 
                             runCount,
                             errorCount);
    }
}

class TestSuite {
    ArrayList<TestCase> tests;
    String log;
    
    TestSuite() {
        tests = new ArrayList<TestCase>();
        log = "";
    }
    
    void add(TestCase test) {
        tests.add(test);
    }
    
    void run(TestResult result) {
        for (TestCase test : tests) {
            test.run(result); 
            log = log + test.log; 
        }
    }
}

// If test class is only used witwh tests, it should be packaged with it.
class TestClass {
    public void testMethod() {
    }
    public void testBrokenMethod() throws Exception {
        throw new Exception();
    }
}
