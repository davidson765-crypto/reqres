package Suites;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.suite.api.*;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = "src/test/java/org/example/users/ui", value = "steps,hooks,context")
@Execution(ExecutionMode.CONCURRENT)
public class RunCucumberTestSuite {
}