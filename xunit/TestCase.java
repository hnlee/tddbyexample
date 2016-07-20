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
    public void run() {
        setUp();
        try {
            Class<?> testClass = Class.forName(className);
            Method testMethod =
testClass.getDeclaredMethod(methodName);
            Object testInstance = testClass.newInstance();
            testMethod.invoke(testInstance);
            log = log + "run ";
        } catch (Exception e) {
        }
    }
    void setUp() {
        log = "setUp ";
    }
}

class TestClass {
    public void testMethod() {
    }
}
