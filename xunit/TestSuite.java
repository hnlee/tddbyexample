import java.util.ArrayList;

class TestSuite {
    private ArrayList<TestCase> tests;
    private String log;

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
            log = log + test.getLog(); 
        }
    }

    String getLog() {
        return log;
    }
}


