import java.lang.reflect.*;

class TestCase {
    String className;
    String methodName;
    TestCase(String name) {
        String[] classMethodName = name.split("\\.");
        this.className = classMethodName[0];
        this.methodName = classMethodName[1];
    }
 
}

class WasRun extends TestCase {
    String wasRun;
    WasRun(String name) {
        super(name);
        this.wasRun = "Not run";
    }
    void run() {
        try {
            Class<?> testClass = Class.forName(className);
            Method testMethod =
testClass.getDeclaredMethod(methodName);
            Object testInstance = testClass.newInstance();
            testMethod.invoke(testInstance);
            wasRun = "Passed";
        } catch (Exception e) {
            wasRun = "Not found";
        }
    }
}

class TestClass {
    public void testMethod() {
    }
}
