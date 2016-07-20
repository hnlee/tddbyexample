import java.lang.reflect.*;

class TestCase {
    String className;
    String methodName;
    String wasRun;
    boolean wasSetUp;
    TestCase(String name) {
        String[] classMethodName = name.split("\\.");
        this.className = classMethodName[0];
        this.methodName = classMethodName[1];
        this.wasRun = "Not run";
    }
    void run() {
        this.setUp();
        try {
            Class<?> testClass = Class.forName(className);
            Method testMethod =
testClass.getDeclaredMethod(methodName);
            Object testInstance = testClass.newInstance();
            testMethod.invoke(testInstance);
            wasRun = "Run";
        } catch (Exception e) {
        }
    }
    void setUp() {
        wasSetUp = true;
    } 
}

class TestClass {
    public void testMethod() {
    }
}
