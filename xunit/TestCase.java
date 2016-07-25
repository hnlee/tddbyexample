import java.lang.reflect.*;
import java.util.ArrayList;

class TestCase {
    String className;
    String methodName;
    String log;
    TestCase(String name) {
        String[] classMethodName = name.split("\\.");
        this.className = classMethodName[0];
        this.methodName = classMethodName[1];
    }

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


