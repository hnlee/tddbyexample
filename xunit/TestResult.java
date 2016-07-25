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
        return String.format("%1$d run, %2$d failed", 
                             runCount,
                             errorCount);
    }
}


