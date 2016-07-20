import java.lang.reflect.*;

class TestCase {
    String className;
    String methodName;
    Boolean wasSetUp;
    Boolean wasRun;
    TestCase(String name) {
        String[] classMethodName = name.split("\\.");
        this.className = classMethodName[0];
        this.methodName = classMethodName[1];
    }
    public void run() {
        setUp();
        try {
            Class<?> testClass = Class.forName(className);
            Method testMethod =
testClass.getDeclaredMethod(methodName);
            Object testInstance = testClass.newInstance();
            testMethod.invoke(testInstance);
            wasRun = true;
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
