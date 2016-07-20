import java.lang.reflect.*;

class WasRun {
    String wasRun;
    String className;
    String methodName;
    WasRun(String name) {
        this.wasRun = "Not run";
        String[] classMethodName = name.split("\\.");
        this.className = classMethodName[0];
        this.methodName = classMethodName[1];
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
