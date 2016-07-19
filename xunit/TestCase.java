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
        Class<?> testClass = Class.forName(className);
        Method testMethod = testClass.getMethod(methodName);
        testMethod.invoke(testClass);
        wasRun = "Passed";
    }
}

class TestClass {
    public void testMethod() {
    }
}
