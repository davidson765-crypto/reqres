package Suites;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.suite.api.*;

@Suite
@SelectClasspathResource("features")
@Execution(ExecutionMode.CONCURRENT)
public class RunCucumberTestSuite {
}