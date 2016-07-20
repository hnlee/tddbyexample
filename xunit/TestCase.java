import java.lang.reflect.*;

class TestCase {
    String className;
    String methodName;
    String log;
    TestCase(String name) {
        String[] classMethodName = name.split("\\.");
        this.className = classMethodName[0];
        this.methodName = classMethodName[1];
    }
    TestResult run() {
        TestResult result = new TestResult();
        result.testStarted();
        setUp();
        try {
            testMethod();
        } catch (Exception e) {
            result.testFailed();
        }
        tearDown();
        return result;
    }
    void setUp() {
        log = "setUp ";
    }
    void testMethod() throws Exception {
        try {
            Class<?> cls = Class.forName(className);
            Method method =
cls.getDeclaredMethod(methodName);
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
        return String.format("%d run, %d failed", 
                             runCount,
                             errorCount);
    }
}

class TestClass {
    public void testMethod() {
    }
    public void testBrokenMethod() throws Exception {
        throw new Exception();
    }
}
