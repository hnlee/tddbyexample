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
    void run() {
        setUp();
        testMethod();
        tearDown();
    }
    void setUp() {
        log = "setUp ";
    }
    void testMethod() {
        try {
            Class<?> cls = Class.forName(className);
            Method method =
cls.getDeclaredMethod(methodName);
            Object obj = cls.newInstance();
            method.invoke(obj);
            log = log + "testMethod ";
        } catch (Exception e) {
        }
    } 
    void tearDown() {
        log = log + "tearDown "; 
    }
}

class TestClass {
    public void testMethod() {
    }
}
